package com.rva.lemma.circuittimer.data.repository

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.entity.Exercise

interface ExerciseRepository {

    suspend fun getAllExercisesByRoutine(routineId: String): LiveData<out List<Exercise>>

    fun getExerciseById(): String

    fun getExercisesByRoutine(): String

    fun createExerciseForRoutine(routineId: String)
}