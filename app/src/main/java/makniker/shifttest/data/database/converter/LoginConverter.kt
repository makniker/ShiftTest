package makniker.shifttest.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import makniker.shifttest.data.models.Login


class LoginConverter {
    @TypeConverter
    fun StringToLogin(string: String): Login = Gson().fromJson(string, Login::class.java)

    @TypeConverter
    fun LoginToString(login: Login): String = Gson().toJson(login)
}