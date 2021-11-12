package domain.usecase

import domain.models.SoilConditionLocalModel
import domain.repository.SoilCoditionRepository

class SoilConditionUseCase(private val repository: SoilCoditionRepository) {

    fun addInfo(soilConditionLocalModel: SoilConditionLocalModel){
        repository.addInfo(soilConditionLocalModel)
    }

    fun updateInfo(soilConditionLocalModel: SoilConditionLocalModel){
        repository.updateInfo(soilConditionLocalModel)
    }

    fun deleteInfo(soilConditionLocalModel: SoilConditionLocalModel){
        repository.deleteInfo(soilConditionLocalModel)
    }

    fun deleteAll(){
        repository.deleteAll()
    }
}