package com.rva.lemma.circuittimer.ui.tracker

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rva.lemma.circuittimer.R
import kotlinx.android.synthetic.main.tracker_fragment.*

class TrackerFragment : Fragment() {

    companion object {
        fun newInstance() = TrackerFragment()
    }

    private lateinit var viewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tracker_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TrackerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
