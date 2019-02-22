package com.rva.lemma.circuittimer.data.database.repository

import androidx.lifecycle.LiveData
import com.rva.lemma.circuittimer.data.database.RoutineDao
import com.rva.lemma.circuittimer.data.database.entity.Routine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.Instant

class RoutineRepositoryImpl(
    private val routineDao: RoutineDao
) : RoutineRepository {

    override suspend fun getRoutineByID(routineID: String): LiveData<out Routine> {
        return withContext(Dispatchers.IO) {
            return@withContext routineDao.getRoutineById(routineID)
        }
    }

    override suspend fun createRoutine(routineID: String) {
        withContext(Dispatchers.IO) {
            val newRoutine = Routine(routineID)
            routineDao.addRoutine(newRoutine)
        }
    }

    override suspend fun getAllRoutines(): LiveData<out List<Routine>> {
        return withContext(Dispatchers.IO) {
            return@withContext routineDao.getRoutines()
        }
    }
}