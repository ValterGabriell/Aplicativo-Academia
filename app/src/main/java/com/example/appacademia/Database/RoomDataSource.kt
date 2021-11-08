package com.example.appacademia.Database

interface RoomDataSource {
    fun addName(dataModel: DataModel)
    fun getAll() : List<DataModel>
    fun deleteAll(dataModel: DataModel)
}