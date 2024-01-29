package makniker.shifttest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import makniker.shifttest.data.database.converter.CoordinatesConverter
import makniker.shifttest.data.database.converter.LocationConverter
import makniker.shifttest.data.database.converter.LoginConverter
import makniker.shifttest.data.database.converter.PictureConverter

@Database(entities = [CacheUserModel::class], version = 1)
@TypeConverters(
    CoordinatesConverter::class,
    LocationConverter::class,
    PictureConverter::class,
    LoginConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
}