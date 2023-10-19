package com.portosdeveloper.protecpersonalapp.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

class ActualDate {
    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault())
    val date: String = dateFormat.format(calendar.time)
    private val hour = calendar.get(Calendar.HOUR_OF_DAY)
    private val minute = calendar.get(Calendar.MINUTE)
    private val second = calendar.get(Calendar.SECOND)
    private val actualHour = "$hour:$minute$second"
    val actualDate = "$date,$actualHour"
}