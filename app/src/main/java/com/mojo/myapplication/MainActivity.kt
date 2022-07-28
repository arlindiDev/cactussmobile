package com.mojo.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val bigRedText = findViewById<TextView>(R.id.bigRedText)
        var count = 0

        bigRedText.text = count.toString()

        val buttonIncrease = findViewById<Button>(R.id.buttonIncrease)
        buttonIncrease.setOnClickListener {
            // kur klikohet buttoni increase
            count ++
            bigRedText.text = count.toString()
        }

        val buttonDecrease = findViewById<Button>(R.id.buttonDecrease)

        buttonDecrease.setOnClickListener {
            // kur klikohet buttoni decrease
            count --
            bigRedText.text = count.toString()
        }

    }
}
