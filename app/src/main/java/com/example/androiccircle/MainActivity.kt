package com.example.androiccircle

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var text1: TextView
    private lateinit var text2: TextView

    private lateinit var btnCounter: Button
    private lateinit var btnDiscount: Button

    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        changeText()
        setActionListener()
    }

    private fun findViews() {
        text1 = findViewById(R.id.textView1)
        text2 = findViewById(R.id.textView2)
        btnCounter = findViewById(R.id.buttonContador)
        btnDiscount = findViewById(R.id.buttonDiscount)
    }

    private fun changeText() {
        if (contador > 10) {
            text1.setText("El contador es mayor a 10 : => $contador")
        } else {
            text1.setText("Contador : => $contador")
        }

        if (contador > 0) {
            btnDiscount.isEnabled = true
        } else {
            btnDiscount.isEnabled = false
        }
    }

    private fun setActionListener() {
        btnCounter.setOnClickListener {
            onClickListenerEventContador()
        }

        btnDiscount.setOnClickListener {
            onClickListenerEventDiscount()
        }
    }

    private fun onClickListenerEventContador() {
        contador++
        changeText()
        // Toast.makeText(this, "hello, bounjour", Toast.LENGTH_SHORT).show()
    }

    private fun onClickListenerEventDiscount() {
        if (contador > 0) {
            contador--
        }
        changeText()
        // Toast.makeText(this, "hello, bounjour", Toast.LENGTH_SHORT).show()
    }
}
