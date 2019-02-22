package com.rva.lemma.circuittimer.data.database.repository

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.entity.Routine

interface RoutineRepository {

    suspend fun getAllRoutines(): LiveData<out List<Routine>>

    suspend fun getRoutineByID(routineID: String): LiveData<out Routine>

    suspend fun createRoutine(routineID: String)
}