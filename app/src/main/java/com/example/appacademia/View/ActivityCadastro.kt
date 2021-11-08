package com.example.appacademia.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.room.RoomDatabase
import com.example.appacademia.Database.DataEntity
import com.example.appacademia.Database.DataModel
import com.example.appacademia.Database.RoomApplication
import com.example.appacademia.R
import com.example.appacademia.ViewModel.CadastroViewModel
import com.example.appacademia.databinding.ActivityCadastroBinding
import com.example.appacademia.databinding.ActivityMainBinding

class ActivityCadastro : AppCompatActivity() {
    private lateinit var binding : ActivityCadastroBinding
    private val model : CadastroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro)

        supportActionBar?.title = "Cadastrar"

        binding.btnSalvar.setOnClickListener {
            val entity = DataModel(0, "${binding.etNameCadastro.text}" , "${binding.etSobrenomeCadastro.text}")
            model.verificaId(this, entity.id, entity)
        }
    }
}