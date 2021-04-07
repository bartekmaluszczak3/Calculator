package com.example.calculator

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import org.mariuszgromada.math.mxparser.Expression

class NormalModeActivity :AppCompatActivity() {
    var signFlag : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_mode)


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
        buttonAdd.setOnClickListener { append("+") }
        val buttonSub = findViewById<Button>(R.id.buttonSub)
        buttonSub.setOnClickListener { append("-") }
        val buttonDiv = findViewById<Button>(R.id.buttonDiv)
        buttonDiv.setOnClickListener { append("/") }
        val buttonMul = findViewById<Button>(R.id.buttonMul)
        buttonMul.setOnClickListener { append("*") }
        val buttonChangeSign = findViewById<Button>(R.id.buttonChangeSign)
        buttonChangeSign.setOnClickListener { changeSign() }
        val buttonBackspace = findViewById<Button>(R.id.buttonBackspace)
        buttonBackspace.setOnClickListener{ backspace() }
        val buttonDot = findViewById<Button>(R.id.buttonDot)
        buttonDot.setOnClickListener { append(".") }
        val buttonC = findViewById<Button>(R.id.buttonC)
        buttonC.setOnClickListener { clear() }
        val buttonEqu = findViewById<Button>(R.id.buttonEqu)
        buttonEqu.setOnClickListener { equal() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textView = findViewById<TextView>(R.id.textView)
        outState.putString("value", textView.text.toString())
        
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(savedInstanceState.getString("value"))
    }

    private fun equal(){

        val textView = findViewById<TextView>(R.id.textView)
        var expression = Expression(textView.text.toString())
        var expr = expression.calculate().toString()
        if(expr.equals("NaN")){
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, "Invalid expression", duration)
            toast.show()
        }
        textView.text = expr

    }

    private fun append(text: String) {
        val textView = findViewById<TextView>(R.id.textView)
        if(signFlag) {
            if(textView.text.equals("") || (! textView.text.last().isDigit() && textView.text.last().toString() != ".")){
                var newText = "-" + text
                textView.append(newText)
                }
            signFlag = false
        }

        else
            textView.append(text)

    }

    private fun clear(){
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = ""
    }

    private fun backspace(){
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = textView.text.substring(0, textView.text.length - 1)
    }

    private fun changeSign(){
        signFlag = ! signFlag
    }
}