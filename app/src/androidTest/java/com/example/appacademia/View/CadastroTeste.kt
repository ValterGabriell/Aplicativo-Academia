package com.example.appacademia.View

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.appacademia.Database.DataDAO
import com.example.appacademia.Database.DataEntity
import com.example.appacademia.Database.DataModel
import com.example.appacademia.Database.DatabaseInstanceService
import com.example.appacademia.R
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CadastroTeste {

    @Rule
    @JvmField
    val rule: ActivityTestRule<ActivityCadastro> = ActivityTestRule(ActivityCadastro::class.java)

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

    @After
    fun teardown(){
        database.close()
    }

    /**
     * cadastrar usuario caso ele nao exista
     * se o id existir, dar falha
     */

    @Test
    fun testeIfIdWasAdded() {
        val entity = DataModel(8, "Lucas", "Pedro")
        val entity2 = DataModel(6, "Lucas", "Pedro")
        val entity3 = DataModel(5, "Lucas", "Pedro")
        val entity4 = DataModel(1, "Lucas", "Pedro")
        dao.addName(DataEntity.fromModlToEntity(entity))
        dao.addName(DataEntity.fromModlToEntity(entity2))
        dao.addName(DataEntity.fromModlToEntity(entity3))
        dao.addName(DataEntity.fromModlToEntity(entity4))

        val result = dao.getAll().map { it.id }
        assertThat(result).contains(1L)
    }




}