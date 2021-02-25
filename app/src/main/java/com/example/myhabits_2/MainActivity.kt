package com.example.myhabits_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val tag = "lifecycle"
        private const val COUNT_EXTRA = "count"
    }

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(
                    applicationContext,
                    SecondActivity::class.java
            ).apply {
                putExtra("count", count)
            }

            startActivity(intent)
        }

        if (savedInstanceState == null){
            countTextView.text = count.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

        log("onCreate")

        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {

        log("onStart")

        super.onStart()
    }

    override fun onResume() {

        log("onResume")

        super.onResume()
    }


    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(COUNT_EXTRA, count)

        log("onSaveInstanceState (сохраняем count - $count)")

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {

        log("onPause")

        super.onPause()
    }

    override fun onStop() {

        log("onStop")

        super.onStop()
    }

    override fun onDestroy() {

        log("onDestroy")

        super.onDestroy()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(COUNT_EXTRA)

        log("onRestoreInstanceState (получаем count - $count)")

        count++

        countTextView.text = count.toString()

        super.onRestoreInstanceState(savedInstanceState)
    }



    private fun log (logText: String) = Log.d(tag, logText)
}