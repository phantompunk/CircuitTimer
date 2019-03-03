package com.rva.lemma.circuittimer.data.repository

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.ExerciseDao
import com.rva.lemma.circuittimer.data.database.entity.Exercise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseRepositoryImpl(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {
    override fun createExerciseForRoutine(routineId: String) {
        exerciseDao.insert(Exercise(routineId = routineId))
    }

    override suspend fun getAllExercisesByRoutine(routineId: String): LiveData<out List<Exercise>> {
        return withContext(Dispatchers.IO) {
            return@withContext exerciseDao.getAllExercisesByRoutine(routineId)
        }
    }

    override fun getExerciseById(): String {
        return "Exercise by Id"
    }

    override fun getExercisesByRoutine(): String {
        return "Exercise by Routine"
    }
}