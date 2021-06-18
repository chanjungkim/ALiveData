package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData


class ALiveArrayListData<T> : MutableLiveData<ArrayList<T>>() {
    private var data: ArrayList<T>? = null

    fun set(data: ArrayList<T>): ALiveArrayListData<T>{
        this.data = data
        return this
    }

    fun get() = this.value

    fun keep(): ALiveArrayListData<T>{
        data = this.value
        this.value = null
        return this
    }

    fun remove(item: T): ALiveArrayListData<T> {
        data?.remove(item)
        return this
    }

    fun add(item: T): ALiveArrayListData<T> {
        data?.add(item)
        return this
    }

    fun addAll(list: List<T>): ALiveArrayListData<T> {
        data?.addAll(list)
        return this
    }

    fun clear(): ALiveArrayListData<T> {
        data?.clear()
        return this
    }

    fun update(){
        this.value = data
        data = null
    }
}