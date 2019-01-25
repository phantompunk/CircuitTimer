package com.rva.lemma.circuittimer.ui.workout.routines

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.rva.lemma.circuittimer.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.workout_routines_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class WorkoutRoutinesFragment() : Fragment(), KodeinAware {
    override val kodein by closestKodein()

    private val viewModelFactory:WorkoutRoutinesViewModelFactory by instance()

    private lateinit var viewModel: WorkoutRoutinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.workout_routines_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(WorkoutRoutinesViewModel::class.java)

        val groupAdapter = GroupAdapter<ViewHolder>()
        groupAdapter.add(RoutineItem())
        groupAdapter.add(RoutineItem())
        groupAdapter.add(RoutineItem())
        groupAdapter.add(RoutineItem())

        workoutRoutinesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        workoutRoutinesRecyclerView.adapter = groupAdapter
    }

}
