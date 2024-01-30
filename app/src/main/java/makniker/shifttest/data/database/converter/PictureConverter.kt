package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.datamodels.Picture

class PictureConverter {
    @TypeConverter
    fun stringToPicture(string: String): Picture = Gson().fromJson(string, Picture::class.java)

    @TypeConverter
    fun pictureToString(picture: Picture): String = Gson().toJson(picture)
}