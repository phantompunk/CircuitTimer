package com.rva.lemma.circuittimer.data.repository

interface ExerciseRepository {

    fun getAllExercises(): String

    fun getExerciseById(): String

    fun getExercisesByRoutine(): String
}