package com.dominic.basiccalculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {

    private lateinit var expression: TextView
    private lateinit var result: TextView
    private lateinit var clear: Button
    private lateinit var backSpace: Button
    private lateinit var percent: Button
    private lateinit var divide: Button
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
        initializeViews()

        expression.movementMethod = ScrollingMovementMethod()
        expression.isActivated = true
        expression.isPressed = true

        setupListeners()
    }

    private fun initializeViews() {
        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        backSpace = findViewById(R.id.backSpace)
        percent = findViewById(R.id.percent)
        divide = findViewById(R.id.divide)
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
    }

    private fun setupListeners() {
        clear.setOnClickListener {
            clearExpression()
        }

        backSpace.setOnClickListener {
            handleBackspace()
        }

        setupOperatorListeners()
        setupNumberListeners()
    }

    private fun clearExpression() {
        updateExpressionText("0")
        expression.textSize = 60F
        result.textSize = 30F
    }

    private fun handleBackspace() {
        val currentText = expression.text.toString()
        if (currentText.isNotEmpty()) {
            val newText = currentText.substring(0, currentText.length - 1)
            updateExpressionText(newText)
            evaluateExpression()
        }
    }

    private fun setupOperatorListeners() {
        val operators = mapOf(
            percent to "%",
            divide to "/",
            multiply to "*",
            add to "+",
            subtract to "-"
        )

        for ((button, operator) in operators) {
            button.setOnClickListener {
                appendOperator(operator)
            }
        }

        equal.setOnClickListener {
            expression.textSize = 30F
            result.textSize = 60F
        }

        dot.setOnClickListener {
            appendOperator(".")
        }
    }

    private fun appendOperator(operator: String) {
        val currentText = expression.text.toString()
        if (currentText.isEmpty() || currentText.last().isOperator() || currentText.endsWith(".")) {
            updateExpressionText(currentText)
        } else {
            updateExpressionText(currentText + operator)
        }
    }

    private fun setupNumberListeners() {
        val numbers = mapOf(
            zero to "0",
            doubleZero to "00",
            one to "1",
            two to "2",
            three to "3",
            four to "4",
            five to "5",
            six to "6",
            seven to "7",
            eight to "8",
            nine to "9"
        )

        for ((button, number) in numbers) {
            button.setOnClickListener {
                appendNumber(number)
            }
        }
    }

    private fun appendNumber(number: String) {
        val currentText = expression.text.toString()
        val newText = if (currentText == "0") number else currentText + number
        updateExpressionText(newText)
        evaluateExpression()
    }

    private fun updateExpressionText(text: String) {
        expression.text = text
    }

    private fun evaluateExpression() {
        val exp = expression.text.toString()
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {
            val res = engine.eval(exp)
            val resultText = if (res.toString().endsWith(".0")) {
                res.toString().replace(".0", "")
            } else {
                res.toString()
            }
            result.text = "=$resultText"
        } catch (e: Exception) {
            handleEvaluationError()
        }
    }

    private fun handleEvaluationError() {
        result.text = getString(R.string.error)
    }

    private fun Char.isOperator(): Boolean {
        return this == '%' || this == '/' || this == '*' || this == '+' || this == '-'
    }
}



