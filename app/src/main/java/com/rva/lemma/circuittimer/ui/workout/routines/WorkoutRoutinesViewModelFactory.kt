package com.rva.lemma.circuittimer.ui.workout.routines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rva.lemma.circuittimer.data.repository.RoutineRepository

class WorkoutRoutinesViewModelFactory(
    private val routineRepository: RoutineRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkoutRoutinesViewModel(routineRepository) as T
    }
}