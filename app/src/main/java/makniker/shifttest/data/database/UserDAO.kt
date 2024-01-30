package makniker.shifttest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import makniker.shifttest.data.datamodels.CacheUserDataModel

@Dao
interface UserDAO {
    @Query("SELECT * FROM cacheuserdatamodel WHERE id= :id LIMIT 1")
    fun getByID(id: String): CacheUserDataModel?

    @Query("SELECT * FROM cacheuserdatamodel")
    fun getUserList(): List<CacheUserDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(models: List<CacheUserDataModel>)

    @Query("DELETE FROM cacheuserdatamodel")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM cacheuserdatamodel")
    fun getRowCount(): Int
}