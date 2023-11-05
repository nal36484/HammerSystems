package com.example.test.presentation.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.test.domain.entities.StatusEnum
import com.example.test.domain.usecases.GetMealListUseCase
import com.example.test.presentation.menu.formatters.MealFormatter
import com.example.test.presentation.menu.models.MealInfo
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getMealListUseCase: GetMealListUseCase,
    private val formatter: MealFormatter
) : ViewModel() {

    private val _banners = MutableLiveData<List<String>>()
    val banners = _banners

    private val _menu = MutableLiveData<List<MealInfo>>()
    val menu = _menu

    fun loadData() {
        viewModelScope.launch { setUpBanners() }
        viewModelScope.launch { loadMenu() }

    }

    private fun setUpBanners() {
        viewModelScope.launch {
            val banners = listOf<String>("1","2")
            _banners.postValue(banners)
        }
    }

    private fun loadMenu() {
        viewModelScope.launch {
            val mealList = getMealListUseCase.execute()
            if (mealList.status == StatusEnum.SUCCESS) {
                val vo = mealList.data?.let { data -> formatter.format(data) }
                _menu.postValue(vo)
            }
        }
    }

    class MenuViewModelFactory(
        private val getMealListUseCase: GetMealListUseCase,
        private val formatter: MealFormatter
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MenuViewModel(
                getMealListUseCase,
                formatter
            ) as T
        }
    }
}