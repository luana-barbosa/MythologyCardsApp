package com.luanabarbosa.details.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luanabarbosa.details.data.model.CoreDetailsModel
import com.luanabarbosa.details.domain.usecase.GetCardInfoUseCase
import com.luanabarbosa.network.response.ApiResponse
import kotlinx.coroutines.launch

class DetailsCardViewModel (
    private val getCardInfoUseCase: GetCardInfoUseCase
) : ViewModel() {
    private val cardsInfo = MutableLiveData<ApiResponse<CoreDetailsModel>>()

    val cardsDetailsInfo: LiveData<ApiResponse<CoreDetailsModel>>
        get() = cardsInfo

    fun loadCardInfo(cardId: String) {
        viewModelScope.launch {
            val info = getCardInfoUseCase(cardId)
            cardsInfo.value = info
        }
    }
}
