package com.rva.lemma.circuittimer.data.repository

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.RoutineDao
import com.rva.lemma.circuittimer.data.database.entity.Routine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoutineRepositoryImpl(
    private val routineDao: RoutineDao
) : RoutineRepository {
    override suspend fun deleteRoutineImmediately(routine: Routine) {
        routineDao.destroyRoutine(routine)
    }

    override fun getRoutineByID(routineID: String): LiveData<out Routine> {
        return routineDao.getRoutineById(routineID)
    }

    override fun createRoutine(routineID: String) {
        val newRoutine = Routine(routineID)
        routineDao.addRoutine(newRoutine)
    }

    override suspend fun getAllRoutines(): LiveData<out List<Routine>> {
        return withContext(Dispatchers.IO) {
            return@withContext routineDao.getRoutines()
        }
    }
}