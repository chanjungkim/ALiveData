package org.koreanlab.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import org.koreanlab.

class MainActivity : AppCompatActivity() {
    val aliveArrayListData = ALiveArrayList<String>()

    var tvPrint: TextView? = null

    var cnt = 0
    val handler = Handler()
    var runnable = Runnable {
        tvPrint!!.text = "ALiveData 테스트 $cnt"
        runTest()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPrint = findViewById<TextView>(R.id.tv_print)
        tvPrint!!.text = "hi"

        runTest()
    }

    private fun runTest(){
        cnt++
        handler.postDelayed(runnable, 500L)
    }
}