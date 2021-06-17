package org.koreanlab.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.lifecycle.Observer
import org.koreanlab.alivedata.ALiveArrayListData

class MainActivity : AppCompatActivity() {
    val aliveArrayListData = ALiveArrayListData<String>()
    val txtList = arrayListOf<String>("말", "고양이", "늑대", "염소")
    var tvPrint: TextView? = null

    var cnt = 0
    val handler = Handler()
    var runnable = Runnable {
        aliveArrayListData
            .add("\nADD 1:${txtList[1]}")
            .add("\nADD 2:${txtList[2]}")
            .update()

        aliveArrayListData
            .add("\nREMOVE 3:${txtList[1]}")
            .add("\nREMOVE 4:${txtList[2]}")

        runTest()
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
            tvPrint!!.text = "ALiveData 테스트 ${++cnt}\n ${it.toString()}"
        })

        // init data
        aliveArrayListData.value = txtList

        runTest()
    }

    private fun runTest(){
        handler.postDelayed(runnable, 5000L)
    }
}