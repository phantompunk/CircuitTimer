package com.rva.lemma.circuittimer.data.database

data class Exercise(
    val name: String,
    val duration: Long,
    val type: ExerciseType
) {
}