package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.models.Timezone

class TimezoneConverter {
    @TypeConverter
    fun StringToTimezone(string: String): Timezone = Gson().fromJson(string, Timezone::class.java)

    @TypeConverter
    fun TimezoneToString(timezone: Timezone): String = Gson().toJson(timezone)
}