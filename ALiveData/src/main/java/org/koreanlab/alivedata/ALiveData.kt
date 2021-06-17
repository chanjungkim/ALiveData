package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData


class ALiveData<T> : MutableLiveData<T>() {
    var data: T? = null

    fun set(data: T){
        this.data = data
    }
    
    fun update(){
        this.value = this.data
    }
}