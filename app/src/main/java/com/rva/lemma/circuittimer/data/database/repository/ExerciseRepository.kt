package com.rva.lemma.circuittimer.data.database.repository

interface ExerciseRepository {

    fun getAllExercises()

    fun getExerciseById()

    fun getExercisesByRoutine()
}