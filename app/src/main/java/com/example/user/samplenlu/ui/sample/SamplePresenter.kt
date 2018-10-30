package com.example.user.samplenlu.ui.sample

import com.example.user.samplenlu.ui.base.BaseMviPresenter
import io.reactivex.Observable

class SamplePresenter : BaseMviPresenter<SampleView, SampleView.State>() {

    override fun intentStream(): Observable<out Any> =
        Observable.merge(
            intent { it.sampleIntent() },
            intent { it.sampleSecondIntent() }
        )

    override fun initialState(): SampleView.State = SampleView.State(false)

    override fun reduceState(state: SampleView.State, changes: Any): SampleView.State = SampleView.State()

}