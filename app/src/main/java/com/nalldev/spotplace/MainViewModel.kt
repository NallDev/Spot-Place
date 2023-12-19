package com.nalldev.spotplace

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(apiService: ApiService) : ViewModel() {
    private val _weather = MutableLiveData<List<Weather>>()
    val weather: LiveData<List<Weather>> = _weather

    init {
        viewModelScope.launch {
            try {
                val data = async(Dispatchers.IO) { apiService.getWeather() }.await()
                val listWeather = async(Dispatchers.Default) {
                    listOf(
                        Weather(
                            name = data.data.forecast.area[0].parameter[0].description,
                            value = data.data.forecast.area[0].parameter[0].timerange[0].value[0].text,
                            unit = data.data.forecast.area[0].parameter[0].timerange[0].value[0].unit
                        ),
                        Weather(
                            name = data.data.forecast.area[0].parameter[5].description,
                            value = data.data.forecast.area[0].parameter[5].timerange[0].value[0].text,
                            unit = data.data.forecast.area[0].parameter[5].timerange[0].value[0].unit
                        )
                    )
                }.await()
                _weather.postValue(listWeather)
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
            }
        }
    }
}


data class Weather(
    val name: String,
    val value: String,
    val unit: String
)