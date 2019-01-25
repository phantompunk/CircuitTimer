package com.rva.lemma.circuittimer.ui.workout.routines

import androidx.lifecycle.ViewModel;
import com.rva.lemma.circuittimer.data.database.repository.RoutineRepository

class WorkoutRoutinesViewModel(
    private val routinesRepository: RoutineRepository
) : ViewModel() {

    private val routines = routinesRepository.getAllRoutines()
}
