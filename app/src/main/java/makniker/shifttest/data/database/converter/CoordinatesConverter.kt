package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.datamodels.Coordinates

class CoordinatesConverter {
    @TypeConverter
    fun stringToCoordinates(string: String): Coordinates =
        Gson().fromJson(string, Coordinates::class.java)

    @TypeConverter
    fun coordinatesToString(coordinates: Coordinates): String = Gson().toJson(coordinates)
}