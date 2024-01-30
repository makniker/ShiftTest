package makniker.shifttest.data.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
@TypeConverters
data class CacheUserDataModel(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo("location") val location: Location,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("phone") val phone: String,
    @ColumnInfo("picture") val picture: Picture,
)