package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData

class ListMutableLiveData<T> : MutableLiveData<List<T>>() {
   fun set(data: List<T>): ListMutableLiveData<T>{
        this.value = data
        return this
    }

    fun get() = this.value

    fun remove(item: T): ListMutableLiveData<T> {
        this.value = this.value!!.toMutableList().minus(item).toList()
        return this
    }

    fun removeAt(i: Int): ListMutableLiveData<T> {
        this.value = this.value!!.toMutableList().apply {
            this.removeAt(i)
        }.toList()
        return this
    }

    fun add(item: T): ListMutableLiveData<T> {
        this.value = this.value!!.toMutableList().plus(item).toList()
        return this
    }

    fun set(i: Int, item: T): ListMutableLiveData<T>{
        this.value = this.value!!.toMutableList().apply {
            this.set(i, item)
        }.toList()
        return this
    }

    fun addItems(vararg items: T): ListMutableLiveData<T>{
        this.value = this.value!!.toMutableList().apply {
            items.forEach {
                add(it)
            }
        }.toList()
        return this
    }

    fun addAll(list: List<T>): ListMutableLiveData<T> {
        this.value = this.value!!.toMutableList().apply {
            list.forEach {
                add(it)
            }
        }.toList()
        return this
    }

    fun clear(): ListMutableLiveData<T> {
        this.value = emptyList()
        return this
    }

    fun update(){
        this.value = this.value
    }
}