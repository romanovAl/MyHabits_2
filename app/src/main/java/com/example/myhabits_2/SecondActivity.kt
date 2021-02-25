package com.example.myhabits_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        private const val COUNT_EXTRA = "count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val countFromMainActivity = intent.extras?.getInt(COUNT_EXTRA)

        countFromMainActivity?.let { count ->
            countTextViewSecondActivity.text = (count * count).toString()
        }
    }
}