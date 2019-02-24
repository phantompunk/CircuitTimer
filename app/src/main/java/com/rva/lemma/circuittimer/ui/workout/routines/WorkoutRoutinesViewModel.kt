package com.rva.lemma.circuittimer.ui.workout.routines

import com.rva.lemma.circuittimer.data.repository.RoutineRepository
import com.rva.lemma.circuittimer.internal.lazyDeferred
import com.rva.lemma.circuittimer.ui.base.WorkoutViewModel
import java.util.*

class WorkoutRoutinesViewModel(
    private val routinesRepository: RoutineRepository
) : WorkoutViewModel(routinesRepository) {

    val routines by lazyDeferred { routinesRepository.getAllRoutines() }

    val newRoutine by lazyDeferred { routinesRepository.createRoutine(UUID.randomUUID().toString())}

    fun createNewRoutine() {
        routinesRepository.createRoutine(UUID.randomUUID().toString())
    }
}
