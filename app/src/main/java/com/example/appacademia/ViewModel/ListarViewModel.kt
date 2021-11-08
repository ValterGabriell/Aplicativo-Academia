package com.example.appacademia.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.appacademia.Database.DataModel
import com.example.appacademia.Database.RoomApplication

class ListarViewModel(application: Application) : AndroidViewModel(application) {
    val lista = MutableLiveData<List<DataModel>>()

    fun getAll() {
        val listaTotal = RoomApplication(getApplication()).getAll()
        lista.postValue(listaTotal)
    }
}