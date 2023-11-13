package com.miu.productapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.productapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val rcvIntent = intent
        if(rcvIntent.hasExtra("name") && rcvIntent.hasExtra("desc") && rcvIntent.hasExtra("price") && rcvIntent.hasExtra("image") && rcvIntent.hasExtra("icon")){
            detailBinding.textPName.text = rcvIntent.getStringExtra("name")
            detailBinding.textPDetails.text = rcvIntent.getStringExtra("desc")
            detailBinding.textPPrice.text = rcvIntent.getStringExtra("price")
            detailBinding.imagePImage.setImageResource(rcvIntent.getIntExtra("image",0))
            detailBinding.imagePIcon.setImageResource(rcvIntent.getIntExtra("icon",0))
        }

        detailBinding.buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}