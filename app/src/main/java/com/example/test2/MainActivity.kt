package com.example.test2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val sourceedittext = findViewById<EditText>(R.id.source)
        val countryedittext = findViewById<EditText>(R.id.country)

        val btn = findViewById<Button>(R.id.button)

        val intent = Intent(this, ActivityTwo::class.java)
        btn.setOnClickListener() {
            val source = sourceedittext.text.toString()
            val country = countryedittext.text.toString()
            intent.putExtra("source", source)
            intent.putExtra("country", country)
            startActivity(intent)
        }
    }
}

