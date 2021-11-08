package com.example.appacademia.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.appacademia.R
import com.example.appacademia.ViewModel.MainViewModel
import com.example.appacademia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private val model : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportActionBar?.title = "Academia"

        binding.btnSubmit.setOnClickListener {
            model.verificaName(this, binding.etMainName.text.toString())
        }

        binding.button2.setOnClickListener {
            val inteint = Intent(this, ActivityCadastro::class.java)
            startActivity(inteint)
        }

        binding.btnList.setOnClickListener {
            val inteint = Intent(this, ListarActivity::class.java)
            startActivity(inteint)
        }

    }

}