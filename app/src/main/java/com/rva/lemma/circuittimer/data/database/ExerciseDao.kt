package com.rva.lemma.circuittimer.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rva.lemma.circuittimer.data.database.entity.Exercise

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exercise: Exercise)

    @Update
    fun update(exercise: Exercise)

    @Delete
    fun delete(exercise: Exercise)

    @Query("SELECT * FROM exercises WHERE routineId = :routineId")
    fun getAllExercisesByRoutine(routineId: String): LiveData<List<Exercise>>

//    @Query("SELECT * from exercises where routineId = :routineId")
//    fun findExercisesForRoutine(routineId: String): List<Exercise>
}