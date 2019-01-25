package com.rva.lemma.circuittimer.ui.workout.routines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rva.lemma.circuittimer.data.database.repository.RoutineRepository

class WorkoutRoutinesViewModelFactory(
    private val routineRepository: RoutineRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkoutRoutinesViewModel(routineRepository) as T
    }
}