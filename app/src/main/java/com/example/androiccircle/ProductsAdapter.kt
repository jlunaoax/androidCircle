package com.example.androiccircle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ProductoViewHolder, position: Int) {
        val producto = products[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        private val precioTextView: TextView = itemView.findViewById(R.id.precioTextView)

        fun bind(product: Product) {
            imageView.setImageResource(product.image)
            nombreTextView.text = product.name
            precioTextView.text = product.price
        }
    }
}
