package com.rva.lemma.circuittimer.ui.workout.routines

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rva.lemma.circuittimer.R
import com.rva.lemma.circuittimer.data.database.entity.Routine
import com.rva.lemma.circuittimer.ui.base.ScopedFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.OnItemLongClickListener
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.workout_routines_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class WorkoutRoutinesFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()

    private val viewModelFactory:WorkoutRoutinesViewModelFactory by instance()

    private lateinit var viewModel: WorkoutRoutinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        return inflater.inflate(R.layout.workout_routines_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(WorkoutRoutinesViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        val allRoutines = viewModel.routines.await()
        allRoutines.observe(this@WorkoutRoutinesFragment, Observer { routines ->
            if (routines.isEmpty()) {
                Log.d("Routines", "Routines DB is empty")
            }
            initRecyclerView(routines.toRoutineItems())
        })

        fab_add_routine!!.setOnClickListener { view ->
            Snackbar.make(view, "New Workout Added!", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            createRoutine()
        }
    }

    private fun createRoutine() = launch(Dispatchers.IO) {
        viewModel.createNewRoutine()
    }

    private fun initRecyclerView(routines: List<RoutineItem>) {
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            setOnItemClickListener(onItemClickListener)
            setOnItemLongClickListener(onItemLongClickListener)
            addAll(routines)
        }

        workoutRoutinesRecyclerView.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(this@WorkoutRoutinesFragment.context)
        }
    }

    private fun List<Routine>.toRoutineItems(): List<RoutineItem> {
        return map { RoutineItem(it) }
    }

    private val onItemClickListener = OnItemClickListener { item, _ ->
        if (item is RoutineItem) {
            val bundle = Bundle()
            bundle.putString("routineId", item.routine.id)
            findNavController().navigate(R.id.action_workoutRoutinesFragment_to_currentRoutineFragment, bundle)
        }
    }

    private val onItemLongClickListener = OnItemLongClickListener { item, _ ->
        Log.d("Long", "Long Click Listener")
        if (item is RoutineItem) {
            deleteRoutine(item)
        }
        true
    }

    private fun deleteRoutine(item: RoutineItem) = launch(Dispatchers.IO) {
        viewModel.deleteRoutine(item.routine)
    }
}


