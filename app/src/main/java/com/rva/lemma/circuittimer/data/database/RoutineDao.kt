package com.rva.lemma.circuittimer.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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
    fun getRoutineById(id: String): LiveData<Routine>

    @Query("SELECT * FROM routines")
    fun getRoutines(): LiveData<List<Routine>>

    @Query("SELECT * FROM routines LIMIT 1")
    fun getLastUsedRoutine(): LiveData<Routine>
}