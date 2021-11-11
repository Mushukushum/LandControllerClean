package com.example.thirdparties.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import data.entity.SoilDatabase
import data.SoilConditionRepositoryImpl
import domain.models.SoilConditionLocalModel
import domain.usecase.SoilConditionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SoilConditionViewModel(application: Application): AndroidViewModel(application) {


    //lateinit var readAllData: LiveData<List<SoilConditionLocalModel>>

    private val repository: SoilConditionRepositoryImpl
    private val useCase: SoilConditionUseCase

    init{
        val soilConditionDao = SoilDatabase.getInstance(application).soilDatabaseDao
        repository = SoilConditionRepositoryImpl(soilConditionDao)
        useCase = SoilConditionUseCase(repository)
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
//            readAllData = useCase.getInfo()
//        }
//    }
}