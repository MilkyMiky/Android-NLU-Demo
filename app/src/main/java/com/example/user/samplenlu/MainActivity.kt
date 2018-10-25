package com.example.user.samplenlu

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import coldash.easynlu.parse.Grammar
import coldash.easynlu.parse.Parser
import coldash.easynlu.parse.Rule
import coldash.easynlu.parse.tokenizers.BasicTokenizer

class MainActivity : AppCompatActivity() {

  val listener = object : RecognitionListener {

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

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val grammar = Grammar(initRules(), "\$ROOT")
    val parser = Parser(grammar, BasicTokenizer(), emptyList())

    val textView = findViewById<TextView>(R.id.tv)
    val editText = findViewById<EditText>(R.id.edit_text)
    val button = findViewById<Button>(R.id.button)
    val buttonRecognize = findViewById<Button>(R.id.button_recognise)
    button.setOnClickListener {
      textView.text = parser.parse(editText.text.toString()).toString()
    }

    val recognizer = SpeechRecognizer.createSpeechRecognizer(this.applicationContext)
    recognizer.setRecognitionListener(listener)
    buttonRecognize.setOnClickListener {
      recognizer.startListening(prepareIntent())
    }

  }

  private fun prepareIntent(): Intent =
    Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).putExtra(
      RecognizerIntent.EXTRA_LANGUAGE_MODEL,
      RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
    ).putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "voice.recognition.test")

  private fun initRules(): List<Rule> =
    listOf(
      Rule("\$ROOT", "\$Setting", "@identity"),
      Rule("\$Setting", "\$Feature \$Action", "@merge"),
      Rule("\$Setting", "\$Action \$Feature", "@merge"),

      Rule("\$Feature", "\$Bluetooth", "{feature: bluetooth}"),
      Rule("\$Feature", "\$Wifi", "{feature: wifi}"),
      Rule("\$Feature", "\$Gps", "{feature: gps}"),

      Rule("\$Bluetooth", "bt"),
      Rule("\$Bluetooth", "bluetooth"),
      Rule("\$Wifi", "wifi"),
      Rule("\$Gps", "gps"),
      Rule("\$Gps", "location"),

      Rule("\$Action", "\$EnableDisable", "{action: @first}"),
      Rule("\$EnableDisable", "?\$Switch \$OnOff", "@last"),
      Rule("\$EnableDisable", "\$Enable", "enable"),
      Rule("\$EnableDisable", "\$Disable", "disable"),

      Rule("\$OnOff", "on", "enable"),
      Rule("\$OnOff", "off", "disable"),
      Rule("\$Switch", "switch"),
      Rule("\$Switch", "turn"),

      Rule("\$Enable", "enable"),
      Rule("\$Disable", "disable"),
      Rule("\$Disable", "kill")

    )
}
