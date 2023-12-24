package com.example.nearBy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.main.usecases.NearByUseCase
import com.example.nearBy.ui.UiModel.NetworkResponseState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NearByActivityViewModel @Inject constructor(
    private val useCase: NearByUseCase
) : ViewModel() {

    private val nearByPlaces: MutableStateFlow<NetworkResponseState> =
        MutableStateFlow(NetworkResponseState.Loading)

    val myResponseFlow: StateFlow<NetworkResponseState> = nearByPlaces

    fun fetchPlaces(userId: Int,
                    page: Int,
                    clientId: String,
                    lat: Double,
                    lon: Double,
                    range: String,
                    q: String) {
        nearByPlaces.value = NetworkResponseState.Loading
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.fetchApi(userId, page, clientId, lat, lon, range, q)
            }
                .onSuccess {
                    nearByPlaces.value = NetworkResponseState.Success(it)
                }
                .onFailure {
                    nearByPlaces.value = NetworkResponseState.Failure(it)
                }
        }
    }
}