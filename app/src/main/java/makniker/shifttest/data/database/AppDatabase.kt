package makniker.shifttest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import makniker.shifttest.data.database.converter.CoordinatesConverter
import makniker.shifttest.data.database.converter.LocationConverter
import makniker.shifttest.data.database.converter.PictureConverter
import makniker.shifttest.data.datamodels.CacheUserDataModel

@Database(entities = [CacheUserDataModel::class], version = 1)
@TypeConverters(
    CoordinatesConverter::class,
    LocationConverter::class,
    PictureConverter::class,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
}