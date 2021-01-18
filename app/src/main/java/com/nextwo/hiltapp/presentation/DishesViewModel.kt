package com.nextwo.hiltapp.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nextwo.hiltapp.domain.repo.IDishesRepo
import javax.inject.Inject

class DishesViewModel @ViewModelInject constructor(
    private val iDishesRepo: IDishesRepo
): ViewModel() {
    val textLiveData by lazy { MutableLiveData<String>() }
    fun getDishes(){
        textLiveData.postValue(iDishesRepo.getDishes())
    }
}