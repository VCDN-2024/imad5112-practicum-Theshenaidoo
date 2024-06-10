package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private lateinit var textview3 : TextView
    private lateinit var buttonMain: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        textview3 = findViewById(R.id.textView3)

        val Days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val MinTemp = intArrayOf(13, 16, 11, 14, 12, 9, 10)
        val MaxTemp = intArrayOf(26, 30, 24, 27, 25, 17, 15)
        val WeatherCondition = arrayOf("Sunny", "Sunny", "Cloudy", "Sunny", "Cloudy", "Raining", "Cold")

        val stringBuilder = StringBuilder()
        for (i in Days.indices) {
            stringBuilder.append("Day: ${Days[i]}, MinTemp: ${MinTemp[i]}, MaxTemp: ${MaxTemp[i]}, Condition: ${WeatherCondition[i]}\n")
        }

        textview3.text = stringBuilder.toString()



        buttonMain = findViewById(R.id.buttonMain)

        buttonMain.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}