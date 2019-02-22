package com.rva.lemma.circuittimer.ui.base

import androidx.lifecycle.ViewModel
import com.rva.lemma.circuittimer.data.database.repository.RoutineRepository

abstract class WorkoutViewModel(
    private val routineRepository: RoutineRepository
) : ViewModel() {
}