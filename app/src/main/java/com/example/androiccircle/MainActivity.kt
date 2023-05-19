package com.example.androiccircle

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val USER_GOOD = "jluna@gmail.com"
    private val PASSWORD_GOOD = "abc123abc"

    private lateinit var textCreateAccount: TextView
    private lateinit var textForgotUsrPwd: TextView

    private lateinit var textUsuario: TextInputEditText
    private lateinit var textPassword: TextInputEditText

    // private lateinit var btnCounter: Button
    // private lateinit var btnDiscount: Button
    private lateinit var btnNextActivity: Button

    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        validaUsuario()
        setActionListener()
    }

    private fun findViews() {
        textCreateAccount = findViewById(R.id.textView1)
        textForgotUsrPwd = findViewById(R.id.textView2)

        textUsuario = findViewById(R.id.textInputUsuario)
        textPassword = findViewById(R.id.textInputPassword)
        // btnCounter = findViewById(R.id.buttonContador)
        // btnDiscount = findViewById(R.id.buttonDiscount)
        btnNextActivity = findViewById(R.id.buttonNextActivity)
    }

    private fun validaUsuario() {
        // btnDiscount.isEnabled = contador > 0
        // btnNextActivity.isEnabled = contador > 10

        // btnNextActivity.isEnabled = textUsuario.length() > 0 && textPassword.length() > 0

       /*when {
            contador > 10 -> {
                text1.setText("El contador es mayor a 10 : => $contador")
            }
            contador > 5 -> {
                text1.setText("El contador es mayor a 5 : => $contador")
            }
            else -> {
                text1.setText("Contador : => $contador")
            }
        }*/
    }

    private fun validEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun setActionListener() {
       /*btnCounter.setOnClickListener {
            onClickListenerEventContador()
        }

        btnDiscount.setOnClickListener {
            onClickListenerEventDiscount()
        }*/

        btnNextActivity.setOnClickListener {
            Toast.makeText(this, "Working...", Toast.LENGTH_SHORT).show()
            if (validEmailButton() && validPasswordButton()) {
                if (validateAccess(textUsuario.text.toString(), textPassword.text.toString())) {
                    goToNextActivity()
                } else {
                    Toast.makeText(this, "You are not able to login", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Error user/pwd", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validEmailButton(): Boolean {
        return validEmail(textUsuario.text.toString())
    }

    private fun validPasswordButton(): Boolean {
        return validPassword(textPassword.text.toString())
    }

    private fun validPassword(password: String): Boolean {
        val passwordPattern = "(?=.*[0-9].*[0-9])[a-zA-Z0-9]{8,}$".toRegex()
        return passwordPattern.matches(password)
    }

    private fun validateAccess(user: String, password: String): Boolean {
        return (user == USER_GOOD && password == PASSWORD_GOOD)
    }

    private fun goToNextActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("contador", contador)
        startActivity(intent)
    }

    /*private fun onClickListenerEventContador() {
        // contador++
        // validaUsuario()
        Toast.makeText(this, "hello, bounjour", Toast.LENGTH_SHORT).show()
    }

    private fun onClickListenerEventDiscount() {
        if (contador > 0) {
            contador--
        }
        validaUsuario()
        // Toast.makeText(this, "hello, bounjour", Toast.LENGTH_SHORT).show()
    }*/
}
