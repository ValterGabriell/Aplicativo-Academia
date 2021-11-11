package com.example.appacademia.ViewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.Toast

import androidx.lifecycle.AndroidViewModel
import com.example.appacademia.Database.RoomApplication
import com.example.appacademia.View.SucessActivity


class MainViewModel (application: Application) : AndroidViewModel(application){


    fun getName(): List<String> {
        return RoomApplication(getApplication()).getAll().map { it.cpf }
    }

    fun verificaName(context: Context ,cpf:String){
        val lista = getName()
        if (cpf.length != 11){
            Toast.makeText(context, "CPF incorreto", Toast.LENGTH_SHORT).show()
        }else{
            if (lista.contains(cpf)){
                Toast.makeText(context, "Sucesso ao Logar", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, SucessActivity::class.java))
            }else{
                Toast.makeText(context, "Usuario nao encontrado, faça seu cadastro", Toast.LENGTH_SHORT).show()
            }
        }

    }





}