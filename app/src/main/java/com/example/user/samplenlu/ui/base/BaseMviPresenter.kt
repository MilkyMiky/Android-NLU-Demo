package com.example.user.samplenlu.ui.base


import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

abstract class BaseMviPresenter<V : BaseMviView<VS>, VS> : MviBasePresenter<V, VS>() {

    override fun bindIntents() {
        subscribeViewState(
            intentStream().scan(initialState(), ::reduceState)
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread()),
            BaseMviView<VS>::render
        )
    }

    protected abstract fun intentStream(): Observable<out Any>

    protected abstract fun initialState(): VS

    protected abstract fun reduceState(state: VS, changes: Any): VS

}