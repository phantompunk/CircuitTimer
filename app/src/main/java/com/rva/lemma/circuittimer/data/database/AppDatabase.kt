package com.rva.lemma.circuittimer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rva.lemma.circuittimer.data.database.entity.Exercise
import com.rva.lemma.circuittimer.data.database.entity.Routine

@Database(entities = [Routine::class, Exercise::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun routineDao(): RoutineDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "AppRoutines.db")
                    .build()
    }
}