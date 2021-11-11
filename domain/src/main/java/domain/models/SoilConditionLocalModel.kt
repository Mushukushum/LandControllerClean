package domain.models

data class SoilConditionLocalModel(
    val id:Long,
    val areaSize:Double,
    val lastAgriculture: String,
    val cropCapacity:Int
) {
    fun getInfo(): SoilConditionLocalModel{
        return SoilConditionLocalModel(id, areaSize, lastAgriculture, cropCapacity)
    }
}