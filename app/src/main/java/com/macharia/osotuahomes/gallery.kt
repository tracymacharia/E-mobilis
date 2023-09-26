package com.macharia.osotuahomes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class gallery : AppCompatActivity() {
    var imagesCard: CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val singlerooms = findViewById<View>(R.id.single)
        imagesCard!!.setOnClickListener { view: View? ->
            val intent = Intent(this@gallery, activity_gallery::class.java)
            startActivity(intent)
        }
    }
}