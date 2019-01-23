package com.rva.lemma.circuittimer.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.rva.lemma.circuittimer.data.database.ExerciseType

@Entity(tableName = "exercises")
data class Exercise(
    @ColumnInfo(name = "name")      val name: String,
    @ColumnInfo(name = "duration")  val duration: Long,
    @ColumnInfo(name = "type")      val type: ExerciseType
) {
}