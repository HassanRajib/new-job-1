package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class productActivity : AppCompatActivity() {
    private lateinit var productVM: productViewModel
    private lateinit var productAda: ProductAdaptar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        productVM = ViewModelProvider(this).get(productViewModel::class.java)
        productAda = ProductAdaptar(emptyList())

        val frhBtn: FloatingActionButton = findViewById(R.id.freshB)

        frhBtn.setOnClickListener {
            startActivity(Intent(this, productActivity::class.java))
            finish()
        }

        val recyclerView: RecyclerView = findViewById(R.id.proD)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAda

        productVM.products.observe(this, Observer { products->
            products?.let {
                productAda = ProductAdaptar(it)
                recyclerView.adapter = productAda
            }
        })
    }
}