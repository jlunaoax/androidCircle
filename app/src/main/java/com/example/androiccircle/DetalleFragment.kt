package com.example.androiccircle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetalleFragment(var product: Product) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalle, container, false)
        val imageView: ImageView = view.findViewById(R.id.imageViewDetail)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val buttonOk: Button = view.findViewById(R.id.okButton)

        imageView.setImageResource(product.image)
        descriptionTextView.text = product.description

        buttonOk.setOnClickListener {
            (requireActivity() as MainActivity2).onBackFromFragmentSpecial()
        }

        /*view.setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }*/
        return view
    }
}
