package com.rva.lemma.circuittimer.ui.workout.current

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
        // TODO: Use the ViewModel

        val groupAdapter = GroupAdapter<ViewHolder>()

        currentRoutineRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CurrentRoutineFragment.context)
            adapter = groupAdapter
        }
    }

}
