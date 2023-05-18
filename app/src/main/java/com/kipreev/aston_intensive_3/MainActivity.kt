package com.kipreev.aston_intensive_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNextStep: Unit =
            findViewById<Button?>(R.id.button_next_step).setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
    }
}