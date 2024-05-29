package com.dominic.basiccalculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var expression: TextView
    private lateinit var result: TextView
    private lateinit var clear : Button
    private lateinit var backSpace: Button
    private lateinit var percent: Button
    private lateinit var devide: Button
    private lateinit var multiply: Button
    private lateinit var add: Button
    private lateinit var subtract: Button
    private lateinit var equal: Button
    private lateinit var dot: Button
    private lateinit var zero: Button
    private lateinit var doubleZero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        backSpace = findViewById(R.id.backSpace)
        percent = findViewById(R.id.percent)
        devide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.add)
        subtract = findViewById(R.id.subtract)
        equal = findViewById(R.id.equal)
        dot = findViewById(R.id.dot)
        zero = findViewById(R.id.zero)
        doubleZero = findViewById(R.id.doubleZero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)

        expression.movementMethod = ScrollingMovementMethod()
        expression.isActivated = true
        expression.isPressed = true

        var str: String

        clear.setOnClickListener {
            expressionText("0")
            expression.textSize = 60F
            result.textSize = 30F
        }
        backSpace.setOnClickListener {
            if (expression.text.toString().isNotEmpty()){
                val lastIndex = expression.text.toString().lastIndex
                str = expression.text.toString().substring(0,lastIndex)
                expressionText(str)
                resultText()
            }
        }
        percent.setOnClickListener {
            if (expression.text.toString().endsWith("%")|| expression.text.toString().endsWith("/")|| expression.text.toString().endsWith("*")|| expression.text.toString().endsWith("+")|| expression.text.toString().endsWith("-")|| expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str = expression.text.toString() + "%"
                expressionText(str)
            }
        }
        devide.setOnClickListener {
            if (expression.text.toString().endsWith("%")|| expression.text.toString().endsWith("/")|| expression.text.toString().endsWith("*")|| expression.text.toString().endsWith("+")|| expression.text.toString().endsWith("-")|| expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str = expression.text.toString() + "/"
                expressionText(str)
            }
        }
        multiply.setOnClickListener {
            if (expression.text.toString().endsWith("%")|| expression.text.toString().endsWith("/")|| expression.text.toString().endsWith("*")|| expression.text.toString().endsWith("+")|| expression.text.toString().endsWith("-")|| expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str = expression.text.toString() + "*"
                expressionText(str)
            }
        }
        add.setOnClickListener {
            if (expression.text.toString().endsWith("%")|| expression.text.toString().endsWith("/")|| expression.text.toString().endsWith("*")|| expression.text.toString().endsWith("+")|| expression.text.toString().endsWith("-")|| expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str = expression.text.toString() + "+"
                expressionText(str)
            }
        }
        subtract.setOnClickListener {
            if (expression.text.toString().endsWith("%")|| expression.text.toString().endsWith("/")|| expression.text.toString().endsWith("*")|| expression.text.toString().endsWith("+")|| expression.text.toString().endsWith("-")|| expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str = expression.text.toString() + "-"
                expressionText(str)
            }
        }
        equal.setOnClickListener {
            expression.textSize = 30F
            result.textSize = 60F
        }
        dot.setOnClickListener {
            if (expression.text.toString().endsWith("%")|| expression.text.toString().endsWith("/")|| expression.text.toString().endsWith("*")|| expression.text.toString().endsWith("+")|| expression.text.toString().endsWith("-")|| expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str = expression.text.toString() + "."
                expressionText(str)
            }
        }
        zero.setOnClickListener {
            if (expression.text.toString().startsWith("0")){
                str  =expression.text.toString().replace("0", "") +"0"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString() +"0"
                expressionText(str)
                resultText()
            }
        }
        doubleZero.setOnClickListener {

        }
        one.setOnClickListener {

        }
        two.setOnClickListener {

        }
        three.setOnClickListener {

        }
        four.setOnClickListener {

        }
        five.setOnClickListener {

        }
        six.setOnClickListener {

        }
        seven.setOnClickListener {

        }
        eight.setOnClickListener {

        }
        nine.setOnClickListener {

        }

    }


    private fun expressionText(str: String){
        expression.text = str
    }
    private fun resultText() {
        TODO("Not yet implemented")
    }
}
