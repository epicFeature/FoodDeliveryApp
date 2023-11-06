package com.example.fooddeliveryapp.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.fooddeliveryapp.api.common.FoodRepository
import com.example.fooddeliveryapp.api.common.FoodType
import com.example.fooddeliveryapp.api.common.model.Food
import com.example.fooddeliveryapp.api.utils.ResponseUtil

class DessertViewModel {
    var observer: MutableLiveData<List<Food>?> = MutableLiveData()

    fun makeApiCall() {
        ResponseUtil.emerge(observer, FoodRepository.getAll(FoodType.DESSERT))
    }
}