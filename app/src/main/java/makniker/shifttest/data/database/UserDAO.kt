package makniker.shifttest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Query("SELECT * FROM cacheusermodel WHERE id= :id LIMIT 1")
    fun getByID(id: String): CacheUserModel?

    @Query("SELECT * FROM cacheusermodel")
    fun getUserList(): List<CacheUserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(models: List<CacheUserModel>)

    @Query("DELETE FROM cacheusermodel")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM cacheusermodel")
    fun getRowCount(): Int
}