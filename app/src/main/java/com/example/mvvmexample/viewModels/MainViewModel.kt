package com.example.mvvmexample.viewModels

import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.models.Blog
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var lst = MutableLiveData<ArrayList<Blog>>()
    var newList = arrayListOf<Blog>()

    fun add(blog: Blog) {
        newList.add(blog)
        lst.value = newList
    }

    fun remove(blog: Blog) {
        newList.remove(blog)
        lst.value = newList
    }

}
