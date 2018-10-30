package com.example.repository.service

import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log
import com.example.core.service.SpeechRecognizeService

/**
 * Created by Mikhail Lysyansky on 26.10.18.
 */
class SpeechRecognizeServiceImpl : RecognitionListener, SpeechRecognizeService {

  override fun onReadyForSpeech(params: Bundle?) {
    Log.d("log", "onReadyForSpeech")
  }

  override fun onRmsChanged(rmsdB: Float) {
    Log.d("log", "onRmsChanged")
  }

  override fun onBufferReceived(buffer: ByteArray?) {
    Log.d("log", "onBufferReceived")
  }

  override fun onPartialResults(partialResults: Bundle?) {
    Log.d("log", "onPartialResults")
  }

  override fun onEvent(eventType: Int, params: Bundle?) {
    Log.d("log", "onEvent")
  }

  override fun onBeginningOfSpeech() {
    Log.d("log", "onBeginningOfSpeech")
  }

  override fun onEndOfSpeech() {
    Log.d("log", "onEndOfSpeech")
  }

  override fun onError(error: Int) {
    Log.d("log", "onError $error")
  }

  override fun onResults(results: Bundle?) {
    Log.d("log", "onResults $results")
    val str = String()

    if (results != null) {
      val data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
      if (data != null)
        for (word in data)
          Log.d("log", "word $word")
    }
  }


}