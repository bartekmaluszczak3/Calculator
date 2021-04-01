package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val advancedButton = findViewById<Button>(R.id.advancedButton)
        val normalButton = findViewById<Button>(R.id.normalButton)
        val quitButton = findViewById<Button>(R.id.quitButton)
        val aboutButton = findViewById<Button>(R.id.aboutButton)

        normalButton.setOnClickListener {
            val intent = Intent(this, NormalModeActivity::class.java)
            startActivity(intent)
        }

        advancedButton.setOnClickListener {
            val intent = Intent(this, AdvancedModeActivity::class.java)
            startActivity(intent)
        }

        aboutButton.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        quitButton.setOnClickListener {
            exitProcess(0)
        }



    }
}