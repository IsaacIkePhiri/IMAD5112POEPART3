package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Statistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        private val numbersArray = IntArray(10);
        private numbersCounter = 0; // 10

        val editText = findViewById<EditText>(R.id.editTextText2)
        val addBtn = findViewById<Button>(R.id.btnADD)
        val TVEnteredNumbers = findViewById <R.id.>()
        val clearBtn = findViewById<Button>(R.id.btnClear)
        val avgBtn = findViewById<Button>(R.id.avgBtn)
        val minmaxBtn = findViewById<Button>(R.id.minmaxBtn)

        addBtn.setOnClickListener {
            val enteredNumber = editText.text.toString().toIntOrNull();

            if (enteredNumber != null && numbersCounter < numberArray.size) {
                numbersArray[numbersCounter] = enteredNumber;
                numbersCounter++;
                updateTextView()

            } else {

            }
        }

        clearBtn.setOnClickListener {
            numbersArray.fill(0);
            numbersCounter = 0;
            updateTextView()

        }

        private updatetextView() {
            TVEnteredNumbers.text = "Numbers in memory: ${numbersArray.joinToString(", ")}"
        }

        avgBtn.setOnclickListener {

            if (numbersCounter > 0) {
                val sum = 0;

                for(number in numbersArray) {
                    sum = sum + number
                }

                val average = sum.toDouble() / numbersCounter
                textViewAverage.text = "Average :  $average"
            } else {
                Toast - "No numbers in array"
                textViewAverage.text = "Average :  "
            }
        }

        minmaxBtn.setOnClickListener {
            if (numbersCounter > 0 ) {
                val minimum = numbersArray[0];
                val maximum = numbersArray[0];

                for (number in numbersArray) {
                    if (number < minimum) {
                        minimum = number;
                    }

                    if (number > maximum) {
                        maximum = number;
                    }
                } else {
                    Toast - No numbers in the array
                    textView.text = "Minimum: NA, Maximum: NA"
                }

                textView.text = "Minimum: $minimum, Maximum: $maximum"
            }
        }

    }
}