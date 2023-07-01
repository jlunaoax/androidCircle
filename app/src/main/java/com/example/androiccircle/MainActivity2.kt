package com.example.androiccircle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var fragmentHolder: FrameLayout
    private lateinit var carritoText: TextView
    private lateinit var listProduct: MutableList<Product>
    private lateinit var endCompraButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        fragmentHolder = findViewById(R.id.fragmentContainer)
        recyclerView.layoutManager = LinearLayoutManager(this)
        carritoText = findViewById(R.id.carrID)
        listProduct = mutableListOf()
        endCompraButton = findViewById(R.id.endCompraButton)

        endCompraButton.setOnClickListener {
            if (listProduct.isNotEmpty()) {
                saveListProductToSharePreferences()
                Toast.makeText(this, "Total de articulos: ${listProduct.size}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "No hay articulos en tu carrito", Toast.LENGTH_SHORT).show()
            }
        }

        val products = listOf(
            Product(R.drawable.image1, "Deportes 1", "$10dls", "Image description 1"),
            Product(R.drawable.image2, "Deportes 1", "$120dls", "Image description 2"),
            Product(R.drawable.image3, "Deportes 1", "$35dls", "Image description 3"),
            Product(R.drawable.image1, "Deportes 1", "$10dls", "Image description 4"),
            Product(R.drawable.image2, "Deportes 1", "$120dls", "Image description 5"),
            Product(R.drawable.image3, "Deportes 1", "$35dls", "Image description 6"),
        )

        productsAdapter = ProductsAdapter(products)
        recyclerView.adapter = productsAdapter
    }

    fun addProduct(product: Product) {
        listProduct.add(product)
        carritoText.text = "CARRITO: ${listProduct.size}"
    }

    private fun saveListProductToSharePreferences() {
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(listProduct)
        editor.putString("LIST_PRODUCT", json)
        editor.apply()
    }

    fun mostrarDellateProducto(product: Product) {
        val fragmentManager = supportFragmentManager
        val fragment = DetalleFragment(product)

        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()

        recyclerView.visibility = View.GONE
        fragmentHolder.visibility = View.VISIBLE
    }

    fun onBackFromFragmentSpecial() {
        recyclerView.visibility = View.VISIBLE
        fragmentHolder.visibility = View.GONE
    }
}
