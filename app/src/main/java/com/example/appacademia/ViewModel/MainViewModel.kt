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
        return RoomApplication(getApplication()).getAll().map { it.name }
    }

    fun verificaName(context: Context ,name:String){
        val lista = getName()
        if (lista.contains(name)){
            Toast.makeText(context, "Sucesso ao Logar", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, SucessActivity::class.java))
        }else{
            Toast.makeText(context, "Usuario nao encontrado, faça seu cadastro", Toast.LENGTH_SHORT).show()
        }
    }





}