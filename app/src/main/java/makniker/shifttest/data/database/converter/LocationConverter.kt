package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.models.Location

class LocationConverter {
    @TypeConverter
    fun StringToLocation(string: String): Location = Gson().fromJson(string, Location::class.java)

    @TypeConverter
    fun LocationToString(location: Location): String = Gson().toJson(location)
}