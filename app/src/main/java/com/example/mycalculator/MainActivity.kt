package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.but7).setOnClickListener { setText("7") }
        findViewById<TextView>(R.id.but8).setOnClickListener { setText("8") }
        findViewById<TextView>(R.id.but9).setOnClickListener { setText("9") }
        findViewById<TextView>(R.id.but4).setOnClickListener { setText("4") }
        findViewById<TextView>(R.id.but5).setOnClickListener { setText("5") }
        findViewById<TextView>(R.id.but6).setOnClickListener { setText("6") }
        findViewById<TextView>(R.id.but1).setOnClickListener { setText("1") }
        findViewById<TextView>(R.id.but2).setOnClickListener { setText("2") }
        findViewById<TextView>(R.id.but3).setOnClickListener { setText("3") }
        findViewById<TextView>(R.id.but0).setOnClickListener { setText("0") }
        findViewById<TextView>(R.id.butDot).setOnClickListener { setText(".") }
        findViewById<TextView>(R.id.butMinus).setOnClickListener { setText("-") }
        findViewById<TextView>(R.id.butPlus).setOnClickListener { setText("+") }
        findViewById<TextView>(R.id.butTimes).setOnClickListener { setText("*") }
        findViewById<TextView>(R.id.butDiv).setOnClickListener { setText("/") }
        findViewById<TextView>(R.id.butOp).setOnClickListener { setText("(") }
        findViewById<TextView>(R.id.butCl).setOnClickListener { setText(")") }
        findViewById<TextView>(R.id.butClean).setOnClickListener {
            findViewById<TextView>(R.id.read).text = ""
            findViewById<TextView>(R.id.write).text = ""
        }
        findViewById<TextView>(R.id.butCount).setOnClickListener {
            try {
                val ex = ExpressionBuilder(findViewById<TextView>(R.id.read).text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if(result == longRes.toDouble()) {
                    findViewById<TextView>(R.id.write).text = longRes.toString()
                }
                else {
                    findViewById<TextView>(R.id.write).text = result.toString()
                }
            } catch (e:Exception) {
                Log.d("Exception", "message: ${e.message}")
            }
        }


    }
    private fun setText(str: String) {
        findViewById<TextView>(R.id.read).append(str)
    }

}