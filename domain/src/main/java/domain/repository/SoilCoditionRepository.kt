package domain.repository

import domain.models.SoilConditionLocalModel

interface SoilCoditionRepository {
    fun addInfo(soil: SoilConditionLocalModel)
    fun updateInfo(soil: SoilConditionLocalModel)
    fun deleteInfo(soil: SoilConditionLocalModel)
    fun deleteAll()
}