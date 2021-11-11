package domain.usecase

import androidx.lifecycle.LiveData
import domain.models.SoilConditionLocalModel
import domain.repository.SoilCoditionRepository

class SoilConditionUseCase(private val repository: SoilCoditionRepository) {

    fun addInfo(soilConditionLocalModel: SoilConditionLocalModel){
        repository.addInfo(soilConditionLocalModel)
    }

    fun updateInfo(soilConditionLocalModel: SoilConditionLocalModel){
        repository.addInfo(soilConditionLocalModel)
    }

    fun deleteInfo(soilConditionLocalModel: SoilConditionLocalModel){
        repository.deleteInfo(soilConditionLocalModel)
    }

    fun deleteAll(){
        repository.deleteAll()
    }

    //suspend fun getInfo():LiveData<List<SoilConditionLocalModel>> = repository.getAllInfo()
}