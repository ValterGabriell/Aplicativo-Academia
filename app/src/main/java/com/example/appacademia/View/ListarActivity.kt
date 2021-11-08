package com.example.appacademia.View

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appacademia.Database.DataModel
import com.example.appacademia.R
import com.example.appacademia.View.Adapter.ListaAdapter
import com.example.appacademia.ViewModel.ListarViewModel
import com.example.appacademia.databinding.ActivityListarBinding

class ListarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListarBinding
    private val model: ListarViewModel by viewModels()
    private lateinit var adapter: ListaAdapter
    private var lista = ArrayList<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Lista de alunos"

        binding = DataBindingUtil.setContentView(this, R.layout.activity_listar)
        model.getAll()
        model.lista.observe(this, {
            lista = it as ArrayList<DataModel>
            adapter = ListaAdapter(lista)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        })
    }
}