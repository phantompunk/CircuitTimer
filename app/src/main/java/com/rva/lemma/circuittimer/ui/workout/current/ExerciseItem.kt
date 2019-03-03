package com.rva.lemma.circuittimer.ui.workout.current

import com.rva.lemma.circuittimer.R
import com.rva.lemma.circuittimer.data.database.entity.Exercise
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.exercise_card.*

class ExerciseItem(
    private val exercise: Exercise
): Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
    }

    override fun getLayout() = R.layout.exercise_card
}