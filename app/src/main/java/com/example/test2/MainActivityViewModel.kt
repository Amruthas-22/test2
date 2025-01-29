package com.example.test2

import android.util.Log


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    private val _newsDetails = MutableLiveData<List<NewsModel>>()
    val newsDetails: LiveData<List<NewsModel>> = _newsDetails

    private var job: Job? = null


    fun getNewsDetails(country:String,sources:String) {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO ) {

                val repository = NewsRepository()
                val response = repository.getNewsInfo(country, sources)
                withContext(Dispatchers.Main) {
                    _newsDetails.value = response
                }

        }
    }
}

