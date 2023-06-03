package com.example.androiccircle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val products = listOf(
            Product(R.drawable.image1, "Deportes 1", "$10dls"),
            Product(R.drawable.image2, "Deportes 1", "$120dls"),
            Product(R.drawable.image3, "Deportes 1", "$35dls"),
        )

        productsAdapter = ProductsAdapter(products)
        recyclerView.adapter = productsAdapter
    }
}
