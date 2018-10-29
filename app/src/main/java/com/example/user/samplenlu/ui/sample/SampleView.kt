package com.example.user.samplenlu.ui.sample

import com.example.user.samplenlu.ui.base.BaseMviView
import io.reactivex.Observable

interface SampleView : BaseMviView<SampleView.State> {

    fun sampleIntent(): Observable<Boolean>
    fun sampleSecondIntent(): Observable<Boolean>

    data class State(
        val state: Boolean = false
    )

    sealed class Event {}

    sealed class StateChanges {}



}