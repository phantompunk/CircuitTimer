package com.rva.lemma.circuittimer.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey
    @ColumnInfo(name = "id")        val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name")      val name: String,
    @ColumnInfo(name = "duration")  val duration: Long,
    @ColumnInfo(name = "type")      val type: String
)