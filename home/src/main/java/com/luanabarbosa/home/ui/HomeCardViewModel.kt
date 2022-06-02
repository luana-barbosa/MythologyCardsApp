package com.luanabarbosa.home.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.domain.GetHomeCardsUseCase
import com.luanabarbosa.network.response.ApiResponse
import kotlinx.coroutines.launch

class HomeCardViewModel(
    private val getHomeCardUseCase: GetHomeCardsUseCase,
) : ViewModel() {

    private val _error = MutableLiveData<Exception>()
    val error = _error as LiveData<Exception>

    private val homeCards: MutableLiveData<List<CoreModel>> = MutableLiveData()

    fun getHomeCards() {
        viewModelScope.launch {
            when (val cardsList = getHomeCardUseCase()) {
                is ApiResponse.Error -> _error.postValue(cardsList.exception)
                is ApiResponse.Success -> {
                    cardsList.data.let {
                        homeCards.postValue(it)
                    }
                }

            }
        }
    }

    fun observerCards(
        lifecycleOwner: LifecycleOwner,
        action: (List<CoreModel>) -> Unit,
    ) = homeCards.observe(lifecycleOwner) {
        action(it)
    }
}