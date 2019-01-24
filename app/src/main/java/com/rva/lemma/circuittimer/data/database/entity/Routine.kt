package com.rva.lemma.circuittimer.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*

@Entity(tableName = "routines")
data class Routine(
    @PrimaryKey
    @ColumnInfo(name = "id")        val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name")      val name: String = "New Workout",
    @ColumnInfo(name = "duration")  val duration: Long,
    @ColumnInfo(name = "exercises") val exercises: List<Exercise>
)