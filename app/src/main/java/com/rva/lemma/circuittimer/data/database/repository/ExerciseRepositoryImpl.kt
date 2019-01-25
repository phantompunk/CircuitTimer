package com.rva.lemma.circuittimer.data.database.repository

class ExerciseRepositoryImpl : ExerciseRepository {
    override fun getAllExercises(): String {
        return "All Exercises"
    }

    override fun getExerciseById(): String {
        return "Exercise by Id"
    }

    override fun getExercisesByRoutine(): String {
        return "Exercise by Routine"
    }
}