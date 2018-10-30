package com.example.repository.service

import coldash.easynlu.parse.Grammar
import coldash.easynlu.parse.Parser
import coldash.easynlu.parse.Rule
import coldash.easynlu.parse.tokenizers.BasicTokenizer
import com.example.core.service.NLUService

/**
 * Created by Mikhail Lysyansky on 26.10.18.
 */
class NLUServiceImpl : NLUService {

  init {
    val grammar = Grammar(initRules(), "\$ROOT")
    val parser = Parser(grammar, BasicTokenizer(), emptyList())
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