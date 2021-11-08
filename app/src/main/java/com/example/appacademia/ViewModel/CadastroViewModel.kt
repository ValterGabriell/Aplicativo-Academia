package com.example.appacademia.ViewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.appacademia.Database.DataModel
import com.example.appacademia.Database.RoomApplication
import com.example.appacademia.View.MainActivity

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    fun addNewData(dataModel: DataModel) {
        RoomApplication(getApplication()).addName(dataModel)
    }

    fun getId(): List<Long> {
        return RoomApplication(getApplication()).getAll().map { it.id }
    }

    fun verificaId(context: Context, id:Long, dataModel: DataModel){
        val list = getId()

        if (list.contains(id)){
            Toast.makeText(context, "Erro ao salvar", Toast.LENGTH_SHORT).show()
        }else{
            addNewData(dataModel)
            Toast.makeText(context, "Sucesso ao salvar", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }


}