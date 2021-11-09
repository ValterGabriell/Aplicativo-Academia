package com.example.appacademia.ViewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.appacademia.Database.DataModel
import com.example.appacademia.Database.RoomApplication
import com.example.appacademia.R
import com.example.appacademia.View.MainActivity

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private val listaArraySpinner =  listOf("Masculino", "Feminino")
    val arrayAdapter = ArrayAdapter<String>(getApplication(), R.layout.support_simple_spinner_dropdown_item, listaArraySpinner)

    fun addNewData(dataModel: DataModel) {
        RoomApplication(getApplication()).addName(dataModel)
    }

    fun getId(): List<String> {
        return RoomApplication(getApplication()).getAll().map { it.cpf }
    }

    fun verificaId(context: Context, cpf:String, dataModel: DataModel){
        val list = getId()

        if (list.contains(cpf)){
            Toast.makeText(context, "Erro ao salvar", Toast.LENGTH_SHORT).show()
        }else{
            addNewData(dataModel)
            Toast.makeText(context, "Sucesso ao salvar", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }


}