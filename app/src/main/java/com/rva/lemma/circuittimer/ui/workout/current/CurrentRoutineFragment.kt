package com.rva.lemma.circuittimer.ui.workout.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rva.lemma.circuittimer.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.current_routine_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentRoutineFragment : Fragment(), KodeinAware {
    override val kodein by closestKodein()

    private val viewModelFactory:CurrentRoutineViewModelFactory by instance()

    private lateinit var viewModel: CurrentRoutineViewModel

//    private var fab: View? = null

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

//        fab = view!!.findViewById(R.id.fab_add)
//        bindUI()

        val groupAdapter = GroupAdapter<ViewHolder>()
        groupAdapter.add(ExerciseItem())
        groupAdapter.add(ExerciseItem())
        groupAdapter.add(ExerciseItem())
        groupAdapter.add(ExerciseItem())

        currentRoutineRecyclerView.adapter = groupAdapter
        currentRoutineRecyclerView.layoutManager = LinearLayoutManager(this.context)
    }

//    private fun bindUI() {
//        fab!!.setOnClickListener { view ->
//            Snackbar.make(view, "Here's a snack", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .show()
//
//        }
//    }
}
