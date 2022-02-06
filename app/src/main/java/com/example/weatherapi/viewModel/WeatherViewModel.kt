package com.example.weatherapi.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.example.weatherapi.TAG
import com.example.weatherapi.network.models.WeatherModel
import com.example.weatherapi.repository.WeatherRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class WeatherViewModel (private val weatherRepository:  WeatherRepository) : ViewModel() {

    private var _weather: MutableLiveData<List<WeatherModel>?> = MutableLiveData()
    val weather: LiveData<List<WeatherModel>?> = _weather

    private var _cityName: MutableLiveData<String> = MutableLiveData()
    val cityName: LiveData<String> get() = _cityName



    fun getCityName(city: View) {
        _cityName.value = city.toString()
    }


//    init {
//        getWeather()
//    }

    private fun getWeather() {
        viewModelScope.launch {
            val response = weatherRepository.getWeather()
            Log.d(TAG, "RESPONSE $response")
            _weather.postValue(response)
        }
    }


    class Factory(
        private val weatherRepository: WeatherRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
                return WeatherViewModel(weatherRepository) as T
            } else {
                throw RuntimeException("Could not create instance of UserViewModel")
            }
        }
    }
}
