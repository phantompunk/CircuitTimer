package com.rva.lemma.circuittimer.data.database.repository

interface RoutineRepository {

    fun getSelectedRoutine(): String

    fun getAllRoutines(): String
}