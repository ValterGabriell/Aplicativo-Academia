package com.example.appacademia.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appacademia.R

class SucessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucess)

        supportActionBar?.title = "Sucesso!"

        val txt = findViewById<TextView>(R.id.txt)
        txt.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}