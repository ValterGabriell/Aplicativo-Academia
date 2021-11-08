package com.example.appacademia.Database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "tabela_academia")
class DataEntity (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
     val id : Long,
    @ColumnInfo(name = "nome")
     val name: String,
    @ColumnInfo(name = "sobrenome")
     val sobrenome:String
        ){

        companion object{
            fun fromModlToEntity(dataModel: DataModel) = DataEntity(dataModel.id, dataModel.name, dataModel.sobrename)
        }
    fun getAll() = DataModel(id, name, sobrenome)
}



