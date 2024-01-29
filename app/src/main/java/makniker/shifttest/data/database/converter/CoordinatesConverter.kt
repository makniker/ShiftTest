package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.models.Coordinates

class CoordinatesConverter {
    @TypeConverter
    fun StringToCoordinates(string: String): Coordinates =
        Gson().fromJson(string, Coordinates::class.java)

    @TypeConverter
    fun CoordinatesToString(coordinates: Coordinates): String = Gson().toJson(coordinates)
}