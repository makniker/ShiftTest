package makniker.shifttest.data.datasources

import makniker.shifttest.data.database.CacheUserModel
import makniker.shifttest.data.database.UserDAO
import javax.inject.Inject

class CacheDataSource @Inject constructor(private val dao: UserDAO) {
    suspend fun getRandomUserList(): List<CacheUserModel> = dao.getUserList()

    suspend fun getUserInfoById(id: String): CacheUserModel {
        TODO()
    }

    fun isUserPresentInDatabase(id: String): Boolean {
        TODO("Not yet implemented")
    }

    suspend fun isEmptyDatabase(): Boolean = dao.getRowCount() == 0

    suspend fun saveList(list: List<CacheUserModel>) {
        dao.deleteAll()
        dao.insertAll(list)
    }
}