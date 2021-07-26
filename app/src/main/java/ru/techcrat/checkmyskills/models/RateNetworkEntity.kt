package ru.techcrat.checkmyskills.models

import ru.techcrat.checkmyskills.models.valutes.Valute

data class RateNetworkEntity(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Valute
)