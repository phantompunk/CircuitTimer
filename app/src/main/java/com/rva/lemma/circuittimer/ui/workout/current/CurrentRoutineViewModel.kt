package com.rva.lemma.circuittimer.ui.workout.current

import androidx.lifecycle.ViewModel;
import com.rva.lemma.circuittimer.data.database.repository.RoutineRepository

class CurrentRoutineViewModel(
    private val routineRepository: RoutineRepository
) : ViewModel() {

    private val routine = routineRepository.getSelectedRoutine()
}
