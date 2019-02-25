package com.rva.lemma.circuittimer.data.repository

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.entity.Routine

interface RoutineRepository {

    suspend fun getAllRoutines(): LiveData<out List<Routine>>

    fun getRoutineByID(routineID: String): LiveData<out Routine>

    fun createRoutine(routineID: String)

    suspend fun deleteRoutineImmediately(routine: Routine)
}