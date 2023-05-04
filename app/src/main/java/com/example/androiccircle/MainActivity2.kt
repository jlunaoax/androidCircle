package com.example.androiccircle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var textActivity2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textActivity2 = findViewById(R.id.textView1Activity2)

        var contadorDesdeActivity1: Int = intent.getIntExtra("contador", 0)

        textActivity2.text = "Valor de contador es => $contadorDesdeActivity1"
    }
}
