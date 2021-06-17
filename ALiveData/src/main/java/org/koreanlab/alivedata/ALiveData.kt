package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData


class ALiveData<T> : MutableLiveData<T>() {
    private var data: T? = null

    fun set(data: T){
        this.data = data
    }

    fun update(){
        this.value = this.data
        data = null
    }
}