package makniker.shifttest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Query("SELECT * FROM cacheusermodel WHERE id= :id LIMIT 1")
    suspend fun getByID(id: String): CacheUserModel?

    @Query("SELECT * FROM cacheusermodel")
    suspend fun getUserList(): List<CacheUserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(models: List<CacheUserModel>)

    @Query("DELETE FROM cacheusermodel")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM cacheusermodel")
    suspend fun getRowCount(): Int
}