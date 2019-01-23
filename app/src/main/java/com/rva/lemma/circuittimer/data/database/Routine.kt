package com.rva.lemma.circuittimer.data.database

import com.rva.lemma.circuittimer.data.database.Exercise

data class Routine(
    val name: String,
    val duration: Long,
    val exercises: List<Exercise>
) {
}