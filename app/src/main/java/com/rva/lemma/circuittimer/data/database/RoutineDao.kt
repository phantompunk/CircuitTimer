package com.rva.lemma.circuittimer.data.database

import androidx.room.*
import com.rva.lemma.circuittimer.data.database.entity.Routine

@Dao
interface RoutineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRoutine(routine: Routine)

    @Update
    fun updateRoutine(routine: Routine)

    @Delete
    fun destroyRoutine(routine: Routine)

    @Query("SELECT * FROM routines WHERE id = :id")
    fun getRoutineById(id: String): Routine
}