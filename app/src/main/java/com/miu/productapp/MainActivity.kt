package com.miu.productapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.miu.productapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val nameList = ArrayList<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, R.drawable.ipad11, R.drawable.macicon ))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00, R.drawable.macbook, R.drawable.macicon))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00, R.drawable.dell, R.drawable.dellicon))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00, R.drawable.keyboard, R.drawable.logitechicon))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00, R.drawable.macmax, R.drawable.macicon))

        var ad_ob = MyAdapter(this, products)
        binding.recycleView1.layoutManager = GridLayoutManager(this, 1)
        binding.recycleView1.adapter = ad_ob

        binding.buttonCart.setOnClickListener {
            val names = nameList.joinToString(", ")
            Toast.makeText(this, "The following products are added to cart: $names",Toast.LENGTH_LONG).show()
        }
    }
    fun addToNameList(productName: String) {
        nameList.add(productName)
    }
}