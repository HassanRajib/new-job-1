package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ApiClint.apiService
import kotlinx.coroutines.launch

class productViewModel:ViewModel() {

    private val _products = MutableLiveData<List<product>>()
    val products:LiveData<List<product>> get() = _products

    init {
        viewModelScope.launch {
            fatechProducts()
        }
    }

    private suspend fun fatechProducts() {
        try {
            val response = apiService.getProducts()
            _products.postValue(response)
        } catch (e:Exception){

        }
    }
}