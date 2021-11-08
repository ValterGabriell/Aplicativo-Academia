package com.example.appacademia.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDAO {

    @Insert
    fun addName(dataEntity: DataEntity)

    @Query("SELECT * FROM tabela_academia")
    fun getAll() : List<DataEntity>

    @Query("DELETE FROM tabela_academia")
    fun deleteAll()
}