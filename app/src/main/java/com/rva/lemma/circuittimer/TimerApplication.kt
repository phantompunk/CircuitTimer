package com.rva.lemma.circuittimer

import android.app.Application
import com.rva.lemma.circuittimer.data.database.AppDatabase
import com.rva.lemma.circuittimer.data.repository.ExerciseRepository
import com.rva.lemma.circuittimer.data.repository.ExerciseRepositoryImpl
import com.rva.lemma.circuittimer.data.repository.RoutineRepository
import com.rva.lemma.circuittimer.data.repository.RoutineRepositoryImpl
import com.rva.lemma.circuittimer.ui.workout.current.CurrentRoutineViewModelFactory
import com.rva.lemma.circuittimer.ui.workout.routines.WorkoutRoutinesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class TimerApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@TimerApplication))

        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { instance<AppDatabase>().routineDao() }
        bind() from singleton { instance<AppDatabase>().exerciseDao() }
        bind<ExerciseRepository>() with singleton { ExerciseRepositoryImpl(instance()) }
        bind<RoutineRepository>() with singleton { RoutineRepositoryImpl(instance()) }
        bind() from provider { CurrentRoutineViewModelFactory(instance(), instance()) }
        bind() from provider { WorkoutRoutinesViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
    }
}