package data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Insert
import data.entity.SoilCondition

@Dao
interface DatabaseDao {

    @Insert
    fun insert(dataObject: SoilCondition)

    @Update
    fun update(dataObject: SoilCondition)

    @Query("SELECT * from soil_condition WHERE id = :key")
    fun get(key: Long): SoilCondition

    @Query("DELETE FROM SOIL_CONDITION")
    fun deleteAll()

    @Delete
    fun delete(dataObject: SoilCondition)

    @Query("SELECT * FROM soil_condition ORDER BY id ASC")
    fun getAllInfo(): LiveData<List<SoilCondition>>
}