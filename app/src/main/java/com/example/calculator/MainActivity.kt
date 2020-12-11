package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Buttons
        var x= 0

        button0.setOnClickListener {
            if (mainStr.text.isNotEmpty())  mainStr.append("0")

        }
        button1.setOnClickListener() {
            mainStr.append("1")
        }
        button2.setOnClickListener() {
            mainStr.append("2")
        }
        button3.setOnClickListener() {
            mainStr.append("3")
        }
        button4.setOnClickListener() {
            mainStr.append("4")
        }
        button5.setOnClickListener() {
            mainStr.append("5")
        }
        button6.setOnClickListener() {
            mainStr.append("6")
        }
        button7.setOnClickListener() {
            mainStr.append("7")
        }
        button8.setOnClickListener() {
            mainStr.append("8")
        }
        button9.setOnClickListener() {
            mainStr.append("9")
        }
        buttonAC.setOnClickListener() {
            mainStr.text = ""

        }
        buttonPerc.setOnClickListener(){

            x++
            if (x % 2 ==1) {
                mainStr.append("(")
            }else
                mainStr.append(")")

        }
        buttonBack.setOnClickListener {
            val str = mainStr.text
            if (str.isNotEmpty()) {
                mainStr.text = str.substring(0, str.length - 1)
            }

        }
        buttonPlus.setOnClickListener() {
            if (mainStr.text.isNotEmpty()) {
                mainStr.append("+")

            }
        }
        buttonMinus.setOnClickListener() {
            if (mainStr.text.isNotEmpty()) {
                mainStr.append("-")

            }

        }
        buttonMult.setOnClickListener {
            if (mainStr.text.isNotEmpty()) {
                mainStr.append("*")
            }

        }
        buttonDiv.setOnClickListener {
            if (mainStr.text.isNotEmpty()) {
                mainStr.append("/")
            }

        }
        buttonDot.setOnClickListener {
                if (mainStr.text.isNotEmpty()) {
                    if( mainStr.text.last().equals('.')){} else {
                        mainStr.append(".")
                    }
                }else  mainStr.append("0.")
            }
        buttonEqual.setOnClickListener {

            try {
                val eva = ExpressionBuilder(mainStr.text.toString()).build()
                val result = eva.evaluate()
                val nedot = result.toLong()
                val formatted = String.format("%.3f", result).replace(',','.')
                if (result.equals(nedot.toDouble())){
                    mainStr.text = nedot.toString()
                } else
                    mainStr.text = formatted



            } catch (e:Exception){
                Log.d("Ошибка"," ${e.message}")
            }
            }




        }
    }





