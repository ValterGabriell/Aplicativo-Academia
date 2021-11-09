package com.example.appacademia.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            if (binding.etMainName.text.isNotEmpty()){
                val cpf = binding.etMainName.text.toString()
                model.verificaName(this, cpf)
            }else{
                Toast.makeText(this, "Preencha o CPF", Toast.LENGTH_SHORT).show()
            }

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