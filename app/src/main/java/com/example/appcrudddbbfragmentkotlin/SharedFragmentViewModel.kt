package com.example.appcrudddbbfragmentkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedFragmentViewModel: ViewModel() {

    var selected: MutableLiveData<Long>? = null

    init {
        selected = MutableLiveData(0L)
    }

    fun selected (n: Long){
        selected?.value = n
    }

}