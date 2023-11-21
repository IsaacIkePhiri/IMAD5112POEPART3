package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setting our references for our interface elements
        val enterNumber = findViewById<TextView>(R.id.enterNumber)
        val enterNumber1 = findViewById<EditText>(R.id.enterNumber1)
        val enterNumber2 = findViewById<EditText>(R.id.enterNumber2)
        val squareRoot = findViewById<EditText>(R.id.et_squareRootValue)
        val displayAnswer = findViewById<TextView>(R.id.displayAnswer)
        val buttonAddition = findViewById<Button>(R.id.buttonAddition)
        val buttonSubtraction = findViewById<Button>(R.id.buttonSubtraction)
        val buttonDivision = findViewById<Button>(R.id.buttonDivision)
        val buttonMultiplication = findViewById<Button>(R.id.buttonMultiplication)
        val buttonPower = findViewById<Button>(R.id.buttonPower)
        val buttonStatistics = findViewById<Button>(R.id.statisticsFunctions)
        val buttonSquareRoot = findViewById<Button>(R.id.buttonSquareRoot)


        buttonSquareRoot.setBackgroundResource(R.drawable.ic_launcher_background)

        buttonAddition.setOnClickListener {
            var res1 = enterNumber1.text.toString().toInt()
            var res2 = enterNumber2.text.toString().toInt()
            var add = res1 + res2
            displayAnswer.text = "{$res1} + {$res2} = ${add}"
        }
        buttonSubtraction.setOnClickListener {
            var res1 = enterNumber1.text.toString().toInt()
            var res2 = enterNumber2.text.toString().toInt()
            var minus = res1 - res2
            displayAnswer.text = "{$res1} - {$res2} = ${minus}"
        }
        buttonMultiplication.setOnClickListener {
            var res1 = enterNumber1.text.toString().toInt()
            var res2 = enterNumber2.text.toString().toInt()
            var multiply = res1 * res2
            displayAnswer.text = "{$res1} * {$res2} = ${multiply}"
        }
        buttonStatistics.setOnClickListener {
            intent = Intent(this,Statistics::class.java);
            startActivity(intent)
        }

        buttonDivision.setOnClickListener {
            if (enterNumber1.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter valid number in field 1", Toast.LENGTH_LONG).show()
            } else if (enterNumber2.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter valid number in field 2", Toast.LENGTH_LONG).show()
            } else if (enterNumber2.text.toString().toInt() == 0){
                Toast.makeText(this, "Division by 0 is not allowed", Toast.LENGTH_LONG).show()
            } else {
                val res1 = enterNumber1.text.toString().toInt()
                val res2 = enterNumber2.text.toString().toInt()
                val div = res1 / res2
                displayAnswer.text = "$res1 / $res2 = $div"
            }

        }
        buttonSquareRoot.setOnClickListener {
            if (squareRoot.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter valid number", Toast.LENGTH_LONG).show()
            } else if (squareRoot.text.toString().toDouble() < 0){
                val value = squareRoot.text.toString().toDouble() * -1
                val result = findSqrt(value)
                displayAnswer.text = "sqrt($value) = $result i"
            } else {
                val value = squareRoot.text.toString().toDouble()
                val result = findSqrt(value)
                displayAnswer.text = "sqrt($value) = $result"
            }
        }
        buttonPower.setOnClickListener {
            if (enterNumber1.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter valid number in field 1", Toast.LENGTH_LONG).show()
            } else if (enterNumber2.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter valid number in field 2", Toast.LENGTH_LONG).show()
            } else {
                val value1 = enterNumber1.text.toString().toInt()
                val value2 = enterNumber2.text.toString().toInt()
                val result = findPowerOf2Numbers(value1, value2)
                displayAnswer.text = "$value1 ^ $value2 = $result"
            }
        }
    }

    private fun findPowerOf2Numbers(number: Int, power:Int): Int{
        var result = 1
        for (i in 0 until power){
            result *= number
        }

        return result
    }

    private fun findSqrt(num: Double): Double {
        if (num < 1) {
            return 1.0 / findSqrt(1.0 / num)
        }

        var guess = 1.0
        var add = num / 2
        while (add >= Math.ulp(guess)) {
            val guess2 = guess + add
            val result = guess2 * guess2
            if (result < num) guess = guess2 else if (result == num) return guess2
            add /= 2.0
        }

        return guess
    }
}

