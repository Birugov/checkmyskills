package ru.techcrat.checkmyskills.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.techcrat.checkmyskills.repos.DateRepos
import javax.inject.Inject

class DateViewModel @Inject constructor(private val repos: DateRepos): ViewModel() {



    val mDates: MutableLiveData<List<String>> = MutableLiveData()
    val data: LiveData<List<String>> = mDates

    fun init() {
        mDates.postValue(repos.setDates())
    }

}