package com.example.user.samplenlu.ui.base

import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseMviView<in VS> : MvpView {
    fun render(viewState: VS)
}