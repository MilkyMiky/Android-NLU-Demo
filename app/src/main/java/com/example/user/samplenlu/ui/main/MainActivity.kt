package com.example.user.samplenlu.ui.main

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.user.samplenlu.R.id
import com.example.user.samplenlu.R.layout

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)


    val textView = findViewById<TextView>(id.tv)
    val editText = findViewById<EditText>(id.edit_text)
    val button = findViewById<Button>(id.button)
    val buttonRecognize = findViewById<Button>(id.button_recognise)
    button.setOnClickListener {
//      textView.text = parser.parse(editText.text.toString()).toString()
    }

//    val recognizer = SpeechRecognizer.createSpeechRecognizer(this.applicationContext)
//    recognizer.setRecognitionListener(listener)
    buttonRecognize.setOnClickListener {
//      recognizer.startListening(prepareIntent())
    }

  }

  private fun prepareIntent(): Intent =
    Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).putExtra(
      RecognizerIntent.EXTRA_LANGUAGE_MODEL,
      RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
    ).putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "voice.recognition.test")

}
