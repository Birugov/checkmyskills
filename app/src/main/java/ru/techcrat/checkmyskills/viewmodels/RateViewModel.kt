package ru.techcrat.checkmyskills.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import ru.techcrat.checkmyskills.models.RateNetworkEntity
import ru.techcrat.checkmyskills.retrofit.RateApiService
import javax.inject.Inject

class RateViewModel
    @Inject constructor(private val apiService: RateApiService) : ViewModel() {

    private var data: MutableLiveData<List<String>> = MutableLiveData()
    val dates: LiveData<List<String>> = data


    fun getRates(){
        CoroutineScope(IO).launch {
            val dataSet = apiService.getRateValues()
            data.postValue(getRateValues(dataSet))
        }
    }

    private fun getRateValues(rates: RateNetworkEntity):ArrayList<String>{
        val ratesValues: ArrayList<String> = ArrayList()
        ratesValues.add(rates.Valute.USD.Value.toString())
        ratesValues.add(rates.Valute.EUR.Value.toString())
        return ratesValues
    }

}
