package com.example.androiccircle

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var fragmentHolder: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        fragmentHolder = findViewById(R.id.fragmentContainer)
        recyclerView.layoutManager = LinearLayoutManager(this)

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
