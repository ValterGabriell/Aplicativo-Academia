package com.example.appacademia.Database

import android.content.Context

class RoomApplication(context: Context) : RoomDataSource{
    private val fetchDao = DatabaseInstanceService.getInstance(context).getDao()

    override fun addName(dataModel: DataModel) {
        fetchDao.addName(DataEntity.fromModlToEntity(dataModel))
    }

    override fun getAll(): List<DataModel> {
        return fetchDao.getAll().map { it.getAll() }
    }

    override fun deleteAll(dataModel: DataModel) {
        fetchDao.deleteAll()
    }
}