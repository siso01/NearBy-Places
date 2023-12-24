package com.example.nearBy.ui.UiModel

sealed class NetworkResponseState {
    object Loading : NetworkResponseState()
    class Failure(val e: Throwable) : NetworkResponseState()
    class Success(val data: Any) : NetworkResponseState()
}