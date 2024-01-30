package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.datamodels.Location

class LocationConverter {
    @TypeConverter
    fun stringToLocation(string: String): Location = Gson().fromJson(string, Location::class.java)

    @TypeConverter
    fun locationToString(location: Location): String = Gson().toJson(location)
}