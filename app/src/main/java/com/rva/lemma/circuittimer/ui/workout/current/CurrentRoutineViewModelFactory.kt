package com.rva.lemma.circuittimer.ui.workout.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rva.lemma.circuittimer.data.repository.ExerciseRepository
import com.rva.lemma.circuittimer.data.repository.RoutineRepository

class CurrentRoutineViewModelFactory(
    private val routineRepository: RoutineRepository,
    private val exerciseRepository: ExerciseRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentRoutineViewModel(routineRepository, exerciseRepository) as T
    }
}