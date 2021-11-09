package com.example.appacademia.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    private lateinit var binding: ActivityCadastroBinding
    private val model: CadastroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro)

        supportActionBar?.title = "Cadastrar"

        binding.btnSalvar.setOnClickListener {
            if (binding.etNameCadastro.text.isNotEmpty()){
                if (binding.etSobrenomeCadastro.text.isNotEmpty()){
                    if (binding.etCpf.text.isNotEmpty()){
                        if (binding.etPeso.text.isNotEmpty()){
                            val entity = DataModel(
                                0,
                                "${binding.etNameCadastro.text}",
                                "${binding.etSobrenomeCadastro.text}",
                                "${binding.etCpf.text}",
                                "${binding.spinner.selectedItem}",
                                "${binding.etPeso.text}"
                            )
                            model.verificaId(this, entity.cpf, entity)
                        }else{
                            Toast.makeText(this, "Preencha o peso", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this, "Preencha o cpf", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Preencha o sobrenome", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Preencha o nome", Toast.LENGTH_SHORT).show()
            }

        }

        binding.spinner.adapter = model.arrayAdapter
    }
}