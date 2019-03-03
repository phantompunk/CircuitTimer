package com.rva.lemma.circuittimer.ui.workout.current

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rva.lemma.circuittimer.R
import com.rva.lemma.circuittimer.data.database.entity.Exercise
import com.rva.lemma.circuittimer.data.database.entity.Routine
import com.rva.lemma.circuittimer.ui.base.ScopedFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.current_routine_fragment.*
import kotlinx.android.synthetic.main.workout_routines_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentRoutineFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()

    private val viewModelFactory:CurrentRoutineViewModelFactory by instance()

    private lateinit var viewModel: CurrentRoutineViewModel

    private var routineId: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_routine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentRoutineViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        if (!routineId.isNullOrBlank()) {
            current_empty_list.visibility = View.GONE
            val routineExercises = viewModel.getAllExercisesForRoutine(routineId!!)
            routineExercises.observe(this@CurrentRoutineFragment, Observer { exercises ->
                if (exercises.isNotEmpty()) {
                    initGroupAdapter(exercises.toExerciseItems())
                }
            })
        } else {
            val latestRoutine = viewModel.getLastUsedRoutine()
            latestRoutine.observe(this@CurrentRoutineFragment, Observer { routine ->
                if (routine != null) {
                    routineId = routine.id
                }
            })
            loadExercises()
        }

        fab_add_be!!.setOnClickListener { view ->
            Snackbar.make(view, "New Workout Added!", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            createExercise()
        }
    }

    private fun loadExercises() = launch(Dispatchers.IO) {
        if (routineId != null) {
            val routineExercises = viewModel.getAllExercisesForRoutine(routineId!!)

            routineExercises.observe(this@CurrentRoutineFragment, Observer { exercises ->
                if (exercises.isNotEmpty()) {
                    initGroupAdapter(exercises.toExerciseItems())
                }
            })
        }
    }

    private fun initGroupAdapter(exerciseItems: List<ExerciseItem>) {
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(exerciseItems)
        }

        currentRoutineRecyclerView.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(this@CurrentRoutineFragment.context)
        }

    }

    private fun createExercise() = launch(Dispatchers.IO) {
        if (!routineId.isNullOrEmpty()) {
            viewModel.createNewExercise(routineId!!)
        }
    }

    private fun initRecyclerView(routine: Routine) {
        Log.d("Currrent", "RoutineID: ${routine.id}")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getString("routineId").let { routineId = it }

        Log.d("Current", "Passed RoutineId: $routineId")
    }
}

private fun List<Exercise>.toExerciseItems(): List<ExerciseItem> {
    return map { ExerciseItem(it) }
}
