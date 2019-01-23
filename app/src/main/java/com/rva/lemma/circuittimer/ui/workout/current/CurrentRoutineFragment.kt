package com.rva.lemma.circuittimer.ui.workout.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rva.lemma.circuittimer.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.current_routine_fragment.*

class CurrentRoutineFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentRoutineFragment()
    }

    private lateinit var viewModel: CurrentRoutineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_routine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentRoutineViewModel::class.java)

        val groupAdapter = GroupAdapter<ViewHolder>()
        groupAdapter.add(ExerciseItem())
        groupAdapter.add(ExerciseItem())
        groupAdapter.add(ExerciseItem())
        groupAdapter.add(ExerciseItem())

        currentRoutineRecyclerView.adapter = groupAdapter
        currentRoutineRecyclerView.layoutManager = LinearLayoutManager(this.context)
    }
}
