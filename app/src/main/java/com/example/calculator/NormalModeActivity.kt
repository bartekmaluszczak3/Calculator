package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NormalModeActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_mode)


        // display

        val textView = findViewById<TextView>(R.id.textView)

        // Numbers

        val buttonOne = findViewById<Button>(R.id.buttonOne)
        buttonOne.setOnClickListener { append("1") }
        val buttonTwo = findViewById<Button>(R.id.buttonTwo)
        buttonTwo.setOnClickListener { append("2") }
        val buttonThree = findViewById<Button>(R.id.buttonThree)
        buttonThree.setOnClickListener { append("3") }
        val buttonFour = findViewById<Button>(R.id.buttonFour)
        buttonFour.setOnClickListener { append("4") }
        val buttonFive = findViewById<Button>(R.id.buttonFive)
        buttonFive.setOnClickListener { append("5") }
        val buttonSix = findViewById<Button>(R.id.buttonSix)
        buttonSix.setOnClickListener { append("6") }
        val buttonSeven = findViewById<Button>(R.id.buttonSeven)
        buttonSeven.setOnClickListener { append("7") }
        val buttonEight = findViewById<Button>(R.id.buttonEight)
        buttonEight.setOnClickListener { append("8") }
        val buttonNine = findViewById<Button>(R.id.buttonNine)
        buttonNine.setOnClickListener { append("9") }

        //operators

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSub = findViewById<Button>(R.id.buttonSub)
        val buttonDiv = findViewById<Button>(R.id.buttonDiv)
        val buttonMul = findViewById<Button>(R.id.buttonMul)
        val buttonLeftB = findViewById<Button>(R.id.buttonLeftB)
        val buttonRightB = findViewById<Button>(R.id.buttonRightB)
        val buttonDot = findViewById<Button>(R.id.buttonDot)
        val buttonC = findViewById<Button>(R.id.buttonC)
        buttonC.setOnClickListener { clear() }

    }



    private fun append(text: String){
        val textView = findViewById<TextView>(R.id.textView)
        textView.append(text)
    }

    private fun clear(){
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = ""
    }
}