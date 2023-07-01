package com.example.androiccircle

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity3 : AppCompatActivity() {
    private lateinit var productsRecived: MutableList<Product>
    private lateinit var textProduct: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        textProduct = findViewById(R.id.itemsList)

        if (null != getListProductFromSharedPreferences()) {
            productsRecived = getListProductFromSharedPreferences()

            var nameString = ""

            for (product in productsRecived) {
                val name = product.name
                nameString += "$name \n"
            }

            textProduct.text = nameString
        }
    }

    private fun getListProductFromSharedPreferences(): MutableList<Product> {
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("LIST_PRODUCT", null)
        val type = object : TypeToken<MutableList<Product>>() {}.type
        return gson.fromJson(json, type)
    }
}
