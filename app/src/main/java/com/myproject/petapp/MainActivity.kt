package com.myproject.petapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnsignin.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
        btnsignup.setOnClickListener {
            startActivity(Intent(this,signup::class.java))
        }
    }
}