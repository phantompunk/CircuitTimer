package com.rva.lemma.circuittimer.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rva.lemma.circuittimer.data.database.entity.Exercise
import java.util.*
import kotlin.collections.ArrayList

class ExerciseConverter {

    var gson = Gson()

    @TypeConverter
    fun fromString(exerciseData: String?): List<Exercise>? {
        if (exerciseData == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return gson.fromJson(exerciseData, listType)
    }

    @TypeConverter
    fun toExerciseData(exercises: List<Exercise>): String? {
        return gson.toJson(exercises)
    }
}