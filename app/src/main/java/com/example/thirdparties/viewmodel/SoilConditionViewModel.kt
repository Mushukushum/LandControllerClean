package com.example.thirdparties.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import data.entity.SoilDatabase
import data.SoilConditionRepositoryImpl
import data.entity.SoilCondition
import domain.models.SoilConditionLocalModel
import domain.usecase.SoilConditionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SoilConditionViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<SoilCondition>>

    private val repository: SoilConditionRepositoryImpl
    private val useCase: SoilConditionUseCase

    init{
        val soilConditionDao = SoilDatabase.getInstance(application).soilDatabaseDao
        repository = SoilConditionRepositoryImpl(soilConditionDao)
        useCase = SoilConditionUseCase(repository)
        readAllData = repository.readAllData
    }

    fun addInfo(soilCondition: SoilConditionLocalModel){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.addInfo(soilCondition)
        }
    }

    fun updateInfo(soilCondition: SoilConditionLocalModel){
        viewModelScope.launch(Dispatchers.IO){
            useCase.updateInfo(soilCondition)
        }
    }

    fun removeInfo(soilCondition: SoilConditionLocalModel){
        viewModelScope.launch(Dispatchers.IO){
            useCase.deleteInfo(soilCondition)
        }
    }

    fun removeAll(){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.deleteAll()
        }
    }

//    fun getAllInfo(){
//        viewModelScope.launch(Dispatchers.IO) {
//            useCase.getInfo()
//            Log.d("All info", useCase.getInfo().toString())
//        }
//    }
}