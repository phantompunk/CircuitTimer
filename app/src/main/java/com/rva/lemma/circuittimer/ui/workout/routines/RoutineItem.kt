package com.rva.lemma.circuittimer.ui.workout.routines

import com.rva.lemma.circuittimer.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.routine_card.*

class RoutineItem: Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
//            routine_name_tv.text
        }
    }

    override fun getLayout() = R.layout.routine_card
}