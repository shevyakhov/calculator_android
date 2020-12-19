package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Buttons
        var countbracket = 0


        zeroButton.setOnClickListener() {
            val num = zeroButton.text.toString()

            if (mainStr.text.isNotEmpty()) mainStr.append(num)
        }

        oneButton.setOnClickListener {
            val num = oneButton.text.toString()
            mainStr.append(num)
        }
        twoButton.setOnClickListener {
                val num = twoButton.text.toString()
                mainStr.append(num)
        }
        threeButton.setOnClickListener() {
            val num = threeButton.text.toString()
            mainStr.append(num)
        }
        fourButton.setOnClickListener() {
            val num = fourButton.text.toString()
            mainStr.append(num)
        }
        fiveButton.setOnClickListener() {
            val num = fiveButton.text.toString()
            mainStr.append(num)
        }
        sixButton.setOnClickListener() {
            val num = sixButton.text.toString()
            mainStr.append(num)
        }
        sevenButton.setOnClickListener() {
            val num = sevenButton.text.toString()
            mainStr.append(num)
        }
        eightButton.setOnClickListener() {
            val num = eightButton.text.toString()
            mainStr.append(num)
        }
        nineButton.setOnClickListener() {
            val num = nineButton.text.toString()
            mainStr.append(num)
        }
        buttonAC.setOnClickListener() {
            mainStr.text = ""

        }
        buttonPerc.setOnClickListener() {

            countbracket++
            if (countbracket % 2 == 1) {
                mainStr.append("(")
            } else
                mainStr.append(")")

        }
        buttonBack.setOnClickListener {
            val str = mainStr.text
            if (str.isNotEmpty()) {
                mainStr.text = str.substring(0, str.length - 1)
            }

        }
        buttonPlus.setOnClickListener() {
            val znak = buttonPlus.text.toString()
            mainStr.append(znak)
            if (mainStr.text.isNotEmpty()) {
                mainStr.append(znak)

            }
        }
        buttonMinus.setOnClickListener() {
            val znak = buttonMinus.text.toString()
            if (mainStr.text.isNotEmpty()) {
                mainStr.append(znak)

            }

        }
        buttonMult.setOnClickListener {
            val znak = buttonMult.text.toString()
            if (mainStr.text.isNotEmpty()) {
                mainStr.append(znak)
            }

        }
        buttonDiv.setOnClickListener {
            val znak = buttonDiv.text.toString()
            if (mainStr.text.isNotEmpty()) {
                mainStr.append(znak)
            }

        }
        buttonDot.setOnClickListener {
            if (mainStr.text.isNotEmpty()) {
                if (mainStr.text.last() != '.') {
                    mainStr.append(".")
                }
            } else mainStr.append("0.")
        }
        buttonEqual.setOnClickListener {

            try {
                val eva = ExpressionBuilder(mainStr.text.toString()).build()
                val result = eva.evaluate()
                val nedot = result.toLong()
                val formatted = String.format("%.3f", result).replace(',', '.')
                if (result.equals(nedot.toDouble())) {
                    mainStr.text = nedot.toString()
                } else
                    mainStr.text = formatted


            } catch (e: Exception) {
                Log.d("Ошибка", " ${e.message}")
                Toast.makeText(this, "ошибка", Toast.LENGTH_SHORT).show()
            }
        }


    }


}





