package ru.techcrat.checkmyskills.repos

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import javax.inject.Singleton
import kotlin.collections.ArrayList


class DateRepos() {
    private val dataSet: ArrayList<String> = ArrayList()

    @SuppressLint("SimpleDateFormat")
    fun setDates(): ArrayList<String> {
        val df1 = SimpleDateFormat("dd-MM-yyyy")
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        val forwardedCal2 = cal2.get(Calendar.YEAR) + 1



        while (cal1.get(Calendar.YEAR) < forwardedCal2) {
            val date: Date = cal1.time
            val convertedString = df1.format(date)
            dataSet.add(convertedString)
            cal1.add(Calendar.DATE, 1)
        }
        return dataSet

    }
}