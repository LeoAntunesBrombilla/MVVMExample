package com.example.mvvmexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mvvmexample.R
import com.example.mvvmexample.models.Blog
import com.example.mvvmexample.viewModels.MainViewModel

class RecyclerAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<Blog>, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): RecyclerAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return NotesViewHolder(root)
    }

    override fun getItemCount(): Int {
        if(arrayList.size == 0) {
            Toast.makeText(context, "Não existe nenhum item", Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.NotesViewHolder, position: Int) {
            holder.bind(arrayList.get(position))
    }

    inner class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: Blog) {
            binding.findViewById<TextView>(R.id.title).text = blog.title
            binding.findViewById<ImageButton>(R.id.delete).setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }
    }


}