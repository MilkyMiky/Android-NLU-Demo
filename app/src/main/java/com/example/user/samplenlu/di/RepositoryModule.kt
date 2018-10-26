package com.example.user.samplenlu.di

import com.example.repository.repository.SampleRepositoryImpl
import org.koin.dsl.module.module

/**
 * Created by Mikhail Lysyansky on 26.10.18.
 */

val repositoryModule = module {
  single { SampleRepositoryImpl.create() }
}