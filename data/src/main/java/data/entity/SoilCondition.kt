package data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.models.SoilConditionLocalModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "soil_condition")
data class SoilCondition(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "area_size")
    var area:Double,

    @ColumnInfo(name = "last_agriculture")
    var lastAgriculture:String,

    @ColumnInfo(name = "crop_capacity")
    var cropCapacity:Int
): Parcelable{
    fun convertToLocal():SoilConditionLocalModel = SoilConditionLocalModel(id, area, lastAgriculture, cropCapacity)
}