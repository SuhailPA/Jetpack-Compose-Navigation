package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.R
import com.example.mycity.data.RestaurantDetails
import com.example.mycity.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState


    fun updateCityName(cityName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                city = cityName
            )
        }
    }

    fun updateRestaurantName(name: String, image: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                name = name,
                image = image
            )
        }
    }

    fun loadData() = listOf<UiState>(
        UiState(
            name = RestaurantDetails.nameList[0],
            city = RestaurantDetails.cityNames[0],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[1],
            city = RestaurantDetails.cityNames[1],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[2],
            city = RestaurantDetails.cityNames[2],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[3],
            city = RestaurantDetails.cityNames[3],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[4],
            city = RestaurantDetails.cityNames[4],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[5],
            city = RestaurantDetails.cityNames[5],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[6],
            city = RestaurantDetails.cityNames[6],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[7],
            city = RestaurantDetails.cityNames[7],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[8],
            city = RestaurantDetails.cityNames[8],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[9],
            city = RestaurantDetails.cityNames[9],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[10],
            city = RestaurantDetails.cityNames[10],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        ),
        UiState(
            name = RestaurantDetails.nameList[11],
            city = RestaurantDetails.cityNames[11],
            image = R.drawable.pic1,
            cityImage = R.drawable.pic2
        )
    )
}
