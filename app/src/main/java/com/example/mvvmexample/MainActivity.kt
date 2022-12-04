package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mvvmexample.adapters.RecyclerAdapter
import com.example.mvvmexample.models.Blog
import com.example.mvvmexample.viewModels.MainViewModel
import com.example.mvvmexample.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var mainRecycler: RecyclerView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainRecycler = findViewById(R.id.listOfItems)
        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        btn = findViewById(R.id.send)
        btn.setOnClickListener {
            addData()
        }

        initialaliseAdapter()
    }

    private fun initialaliseAdapter() {
        mainRecycler.layoutManager = viewManager
        observeData()
    }

    fun observeData() {
        viewModel.lst.observe(this, Observer {
            Log.i("data", it.toString())
            mainRecycler.adapter = RecyclerAdapter(viewModel, it, this)
        })
    }

    private fun addData() {
        var txtPlace = findViewById<EditText>(R.id.titleText)
        Log.i("fala fiote", txtPlace.text.toString())
        var title = txtPlace.text.toString()
        if(title.isNullOrBlank()) {
            Toast.makeText(this, "Entre com o valor!", Toast.LENGTH_LONG).show()
        } else {
            var blog = Blog(title)
            viewModel.add(blog)
            txtPlace.text.clear()
            mainRecycler.adapter?.notifyDataSetChanged()
        }


    }
}