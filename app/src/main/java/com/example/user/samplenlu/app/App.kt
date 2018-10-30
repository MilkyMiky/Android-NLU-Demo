package com.example.user.samplenlu.app

import android.app.Application
import com.example.user.samplenlu.di.appModule
import com.example.user.samplenlu.di.repositoryModule
import org.koin.android.ext.android.startKoin

/**
 * Created by Mikhail Lysyansky on 26.10.18.
 */
class App : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin(
      this, listOf(
        appModule,
        repositoryModule
      )
    )
  }
}