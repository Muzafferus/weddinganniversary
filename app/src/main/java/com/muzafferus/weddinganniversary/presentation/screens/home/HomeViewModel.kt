package com.muzafferus.weddinganniversary.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muzafferus.weddinganniversary.domain.model.CoupleData
import com.muzafferus.weddinganniversary.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _coupleData = MutableStateFlow(ArrayList<CoupleData>())
    val coupleData: StateFlow<ArrayList<CoupleData>> = _coupleData

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _coupleData.value =
                useCases.getCoupleDataUseCase()
                    .stateIn(viewModelScope)
                    .value
        }
    }

}