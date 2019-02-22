package com.rva.lemma.circuittimer.ui.workout.current

import com.rva.lemma.circuittimer.data.database.repository.RoutineRepository
import com.rva.lemma.circuittimer.internal.lazyDeferred
import com.rva.lemma.circuittimer.ui.base.WorkoutViewModel

class CurrentRoutineViewModel(
    private val routineRepository: RoutineRepository
) : WorkoutViewModel(routineRepository) {

    private val currentRoutine by lazyDeferred { routineRepository.createRoutine("90") }
}
