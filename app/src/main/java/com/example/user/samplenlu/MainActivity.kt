package com.example.user.samplenlu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import coldash.easynlu.parse.Grammar
import coldash.easynlu.parse.Parser
import coldash.easynlu.parse.Rule
import coldash.easynlu.parse.tokenizers.BasicTokenizer

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val grammar = Grammar(initRules(), "\$ROOT")
    val parser = Parser(grammar, BasicTokenizer(), emptyList())

    val textView = findViewById<TextView>(R.id.tv)
    val editText = findViewById<EditText>(R.id.edit_text)
    val button = findViewById<Button>(R.id.button)
    button.setOnClickListener {
      textView.text = parser.parse(editText.text.toString()).toString()
    }
  }

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
