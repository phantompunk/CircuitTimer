package com.rva.lemma.circuittimer.ui.workout.current

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.entity.Exercise
import com.rva.lemma.circuittimer.data.database.entity.Routine
import com.rva.lemma.circuittimer.data.repository.ExerciseRepository
import com.rva.lemma.circuittimer.data.repository.RoutineRepository
import com.rva.lemma.circuittimer.internal.lazyDeferred
import com.rva.lemma.circuittimer.ui.base.WorkoutViewModel

class CurrentRoutineViewModel(
    private val routineRepository: RoutineRepository,
    private val exerciseRepository: ExerciseRepository
) : WorkoutViewModel(routineRepository) {

    fun getRoutine(routineId: String): LiveData<out Routine> {
        return routineRepository.getRoutineByID(routineId)
    }

    fun createNewExercise(routineId: String) {
        exerciseRepository.createExerciseForRoutine(routineId)
    }

    suspend fun getAllExercisesForRoutine(routineId: String): LiveData<out List<Exercise>> {
        return exerciseRepository.getAllExercisesByRoutine(routineId)
    }

    suspend fun getLastUsedRoutine(): LiveData<out Routine> {
        return routineRepository.getLastUsedRoutine()
    }

    private val currentRoutine by lazyDeferred { routineRepository.createRoutine("90") }
}
