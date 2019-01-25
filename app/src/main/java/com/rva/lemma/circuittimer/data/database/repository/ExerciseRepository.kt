package com.rva.lemma.circuittimer.data.database.repository

interface ExerciseRepository {

    fun getAllExercises(): String

    fun getExerciseById(): String

    fun getExercisesByRoutine(): String
}