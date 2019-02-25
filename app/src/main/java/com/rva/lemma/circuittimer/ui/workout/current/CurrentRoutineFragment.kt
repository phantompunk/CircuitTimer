package com.rva.lemma.circuittimer.ui.workout.current

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.rva.lemma.circuittimer.R
import com.rva.lemma.circuittimer.ui.base.ScopedFragment
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

//        val groupAdapter = GroupAdapter<ViewHolder>()
//        groupAdapter.add(ExerciseItem())
//        groupAdapter.add(ExerciseItem())
//        groupAdapter.add(ExerciseItem())
//        groupAdapter.add(ExerciseItem())
//
//        currentRoutineRecyclerView.adapter = groupAdapter
//        currentRoutineRecyclerView.layoutManager = LinearLayoutManager(this.context)
        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        if (!routineId.isNullOrBlank())
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getString("routineId").let { routineId = it }

        Log.d("Current", "Passed RoutineId: $routineId")
    }
}
