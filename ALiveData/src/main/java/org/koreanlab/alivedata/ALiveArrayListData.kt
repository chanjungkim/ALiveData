package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData


class ALiveArrayListData<T> : MutableLiveData<ArrayList<T>>() {
    init {
        this.value = ArrayList()
    }

    fun add(item: T): ALiveArrayListData<T> {
        this.value?.add(item)
        return this
    }

    fun addAll(list: List<T>): ALiveArrayListData<T> {
        this.value?.addAll(list)
        return this
    }

    fun clear(): ALiveArrayListData<T> {
        this.value?.clear()
        return this
    }

    fun remove(item: T): ALiveArrayListData<T> {
        this.value?.remove(item)
        return this
    }

    fun update(){
        this.value = this.value
    }
}