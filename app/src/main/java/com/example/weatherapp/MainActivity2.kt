package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var textView4: TextView
    private lateinit var buttonExit: Button
    private lateinit var buttonViewScreen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        textView4 = findViewById(R.id.textView4)
        buttonExit = findViewById(R.id.buttonExit)
        buttonViewScreen = findViewById(R.id.buttonViewScreen)

        buttonExit.setOnClickListener {
            finish()
        }

        buttonViewScreen.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val Days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val MinTemp = intArrayOf(13, 16, 11, 14, 12, 9, 10)
        val MaxTemp = intArrayOf(26, 30, 24, 27, 25, 17, 15)
        val WeatherCondition = arrayOf("Sunny", "Sunny", "Cloudy", "Sunny", "Cloudy", "Raining", "Cold")

        var totalMinTemp = 0
        var totalMaxTemp = 0

        for (i in Days.indices) {
            totalMinTemp += MinTemp[i]
            totalMaxTemp += MaxTemp[i]
        }


        val averageMinTemp = totalMinTemp / Days.size.toDouble()
        val averageMaxTemp = totalMaxTemp / Days.size.toDouble()
        val averageTemp = (averageMinTemp + averageMaxTemp) / 2

        textView4.text = "Average Temperature for the week:" + averageTemp.toString()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
