package com.example.mvvmexample.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.R
import com.example.mvvmexample.models.Blog

class RecyclerAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<Blog>, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): RecyclerAdapter.Notes {}


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder() {

    }

    inner class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: Blog) {
            binding.findViewById<TextView>(R.id.title).text = blog.title
        }
    }


}