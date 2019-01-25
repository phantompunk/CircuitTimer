package com.rva.lemma.circuittimer.ui.workout.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rva.lemma.circuittimer.data.database.repository.RoutineRepository

class CurrentRoutineViewModelFactory(
    private val routineRepository: RoutineRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentRoutineViewModel(routineRepository) as T
    }
}