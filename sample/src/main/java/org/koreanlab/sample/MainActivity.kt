package org.koreanlab.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.lifecycle.Observer
import org.koreanlab.alivedata.ALiveArrayListData

class MainActivity : AppCompatActivity() {
    val aliveArrayListData = ALiveArrayListData<String>()

    val txtList = arrayListOf<String>("horse", "cat", "wolf", "goat")
    var tvPrint: TextView? = null

    var cnt = 0
    val handler = Handler()
    var runnable = Runnable {
        // This is valid for the first time
        aliveArrayListData
            .add("\nADD 1:${txtList[1]}")
            .add("\nADD 2:${txtList[2]}")
            .update()

        // This won't do anything
        aliveArrayListData
            .add("\nADD 3:${txtList[1]}")
            .add("\nADD 4:${txtList[2]}")

        // You need to set new value to make aliveArrayListData usable
        aliveArrayListData
            .set(txtList)
            .add("\n===========")
            .update()

        // You need to use keep() for keeping the current data of ALiveArrayListData after calling update.
        aliveArrayListData
            .keep()
            .add("\nADD 5:${txtList[1]}")
            .add("\nADD 6:${txtList[2]}")
            .update()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        tvPrint = findViewById<TextView>(R.id.tv_print)

        // Observe
        aliveArrayListData.observe(this, Observer {
            tvPrint!!.text = "ALiveData Test ${++cnt}\n ${it.toString()}"
            runTest()
        })

        // init data
        aliveArrayListData.set(txtList)

        runTest()
    }

    private fun runTest(){
        handler.postDelayed(runnable, 5000L)
    }
}