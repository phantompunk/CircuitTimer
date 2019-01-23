package com.rva.lemma.circuittimer.ui.workout.routines

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rva.lemma.circuittimer.R

class WorkoutRoutinesFragment : Fragment() {

    companion object {
        fun newInstance() = WorkoutRoutinesFragment()
    }

    private lateinit var viewModel: WorkoutRoutinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.workout_routines_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WorkoutRoutinesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
