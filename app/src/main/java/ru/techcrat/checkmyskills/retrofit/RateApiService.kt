package ru.techcrat.checkmyskills.retrofit

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import retrofit2.http.GET
import ru.techcrat.checkmyskills.models.RateNetworkEntity

interface RateApiService {

    @GET("daily_json.js")
    suspend fun getRateValues(): RateNetworkEntity

}
