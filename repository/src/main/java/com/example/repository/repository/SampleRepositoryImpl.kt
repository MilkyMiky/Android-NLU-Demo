package com.example.repository.repository

import com.example.core.repo.SampleRepository

/**
 * Created by Mikhail Lysyansky on 26.10.18.
 */
class SampleRepositoryImpl : SampleRepository {

  companion object {
    fun create() : SampleRepository = SampleRepositoryImpl()
  }

}