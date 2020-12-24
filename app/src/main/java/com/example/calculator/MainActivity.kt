 package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Buttons
        var countbracket = 0

        for (i in butGroup.referencedIds.indices){
            findViewById<Button>(butGroup.referencedIds[i]).setOnClickListener(){
               val num = (it as Button).text
                 mainStr.append(num)

            }
            }


        buttonAC.setOnClickListener() {
        mainStr.text = ""

        }
        buttonDot.setOnClickListener {
            if (mainStr.text.isNotEmpty()) {
                if (mainStr.text.last() != '.') {
                    mainStr.append(".")
                }
            } else mainStr.append("0.")
        }
        buttonBack.setOnClickListener {
            val str = mainStr.text
            if (str.isNotEmpty()) {
                mainStr.text = str.substring(0, str.length - 1)
            }

        }
        buttonPerc.setOnClickListener() {

            countbracket++
            if (countbracket % 2 == 1) {
                mainStr.append("(")
            } else
                mainStr.append(")")

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




