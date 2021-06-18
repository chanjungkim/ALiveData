package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData

class ArrayListMutableLiveData<T> : MutableLiveData<ArrayList<T>>() {
    private var data: ArrayList<T>? = null

    fun set(data: ArrayList<T>): ArrayListMutableLiveData<T>{
        this.data = data
        return this
    }

    fun get() = this.value

    fun keep(): ArrayListMutableLiveData<T>{
        data = this.value
        this.value = null
        return this
    }

    fun remove(item: T): ArrayListMutableLiveData<T> {
        data?.remove(item)
        return this
    }

    fun add(item: T): ArrayListMutableLiveData<T> {
        data?.add(item)
        return this
    }

    fun addAll(list: List<T>): ArrayListMutableLiveData<T> {
        data?.addAll(list)
        return this
    }

    fun clear(): ArrayListMutableLiveData<T> {
        data?.clear()
        return this
    }

    fun update(){
        this.value = data
        data = null
    }
}