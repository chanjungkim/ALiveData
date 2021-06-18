package org.koreanlab.alivedata

import androidx.lifecycle.MutableLiveData

class ALiveListData<T> : MutableLiveData<List<T>>() {
   fun set(data: List<T>): ALiveListData<T>{
        this.value = data
        return this
    }

    fun get() = this.value

    fun remove(item: T): ALiveListData<T> {
        this.value = this.value!!.toMutableList().minus(item).toList()
        return this
    }

    fun removeAt(i: Int): ALiveListData<T> {
        this.value = this.value!!.toMutableList().apply {
            this.removeAt(i)
        }.toList()
        return this
    }

    fun add(item: T): ALiveListData<T> {
        this.value = this.value!!.toMutableList().plus(item).toList()
        return this
    }

    fun set(i: Int, item: T): ALiveListData<T>{
        this.value = this.value!!.toMutableList().apply {
            this.set(i, item)
        }.toList()
        return this
    }

    fun addItems(vararg items: T): ALiveListData<T>{
        this.value = this.value!!.toMutableList().apply {
            items.forEach {
                plus(it)
            }
        }.toList()
        return this
    }

    fun addAll(list: List<T>): ALiveListData<T> {
        this.value = this.value!!.toMutableList().apply {
            list.forEach {
                plus(it)
            }
        }.toList()
        return this
    }

    fun clear(): ALiveListData<T> {
        this.value = this.value!!.toMutableList().apply {
            clear()
        }
        return this
    }

    fun update(){
        this.value = this.value
    }
}