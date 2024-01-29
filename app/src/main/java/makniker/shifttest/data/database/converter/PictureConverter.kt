package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.models.Picture

class PictureConverter {
    @TypeConverter
    fun StringToPicture(string: String): Picture = Gson().fromJson(string, Picture::class.java)

    @TypeConverter
    fun PictureToString(picture: Picture): String = Gson().toJson(picture)
}