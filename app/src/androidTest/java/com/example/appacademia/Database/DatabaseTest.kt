package com.example.appacademia.Database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class DatabaseTest {
    private lateinit var database: DatabaseInstanceService
    private lateinit var dao: DataDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DatabaseInstanceService::class.java
        ).allowMainThreadQueries().build()

        dao = database.getDao()
    }

    @Test
    fun addName(){
        val entidade = DataModel(5, "Gabriel", "Brito")
        dao.addName(DataEntity.fromModlToEntity(entidade))

        val lista = dao.getAll().map { it.getAll() }
        assertThat(lista).contains(entidade)


    }


}