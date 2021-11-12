package data

import androidx.lifecycle.LiveData
import data.dao.DatabaseDao

import data.entity.SoilCondition
import domain.models.SoilConditionLocalModel
import domain.repository.SoilCoditionRepository

class SoilConditionRepositoryImpl(private val databaseDao: DatabaseDao):SoilCoditionRepository {

    val readAllData: LiveData<List<SoilCondition>> = databaseDao.getAllInfo()


    override fun addInfo(soil: SoilConditionLocalModel) {
        databaseDao.insert(SoilCondition(
                0,
                area = soil.areaSize,
                lastAgriculture = soil.lastAgriculture,
                cropCapacity = soil.cropCapacity
            )
        )
    }

    override fun updateInfo(soil: SoilConditionLocalModel) {
        databaseDao.update(SoilCondition(
                id = soil.id,
                area = soil.areaSize,
                lastAgriculture = soil.lastAgriculture,
                cropCapacity = soil.cropCapacity
            )
        )
    }

    override fun deleteInfo(soil: SoilConditionLocalModel) {
        databaseDao.delete(
            SoilCondition(
                id = soil.id,
                area = soil.areaSize,
                lastAgriculture = soil.lastAgriculture,
                cropCapacity = soil.cropCapacity
            )
        )
    }

    override fun deleteAll() {
        databaseDao.deleteAll()
    }
}