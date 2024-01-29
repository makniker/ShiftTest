package makniker.shifttest.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import makniker.shifttest.data.models.Location
import makniker.shifttest.data.models.Login
import makniker.shifttest.data.models.Picture

@Entity
@TypeConverters
data class CacheUserModel(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo("gender") val gender: String,
    @ColumnInfo("location") val location: Location,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("login") val login: Login,
    @ColumnInfo("phone") val phone: String,
    @ColumnInfo("cell") val cell: String,
    @ColumnInfo("picture") val picture: Picture,
)