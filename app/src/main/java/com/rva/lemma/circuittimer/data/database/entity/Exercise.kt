package com.rva.lemma.circuittimer.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
import com.rva.lemma.circuittimer.data.database.ExerciseType
import java.util.*

@Entity(tableName = "exercises",
        foreignKeys = [ForeignKey(
            entity = Routine::class,
            parentColumns = ["id"],
            childColumns = ["routineId"],
            onDelete = CASCADE)],
        indices = [Index("routineId")]
)
data class Exercise(
    @PrimaryKey
    @ColumnInfo(name = "exerciseId")    val exerciseId: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name")          val name: String = "New Exercise",
    @ColumnInfo(name = "duration")      val duration: Long = 120,
    @ColumnInfo(name = "type")          val type: String = ExerciseType.WORK.name,
    @ColumnInfo(name = "routineId")     val routineId: String
)