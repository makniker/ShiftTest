package makniker.shifttest.data.datasources

import makniker.shifttest.data.database.CacheUserModel
import makniker.shifttest.data.database.UserDAO
import javax.inject.Inject

class CacheDataSource @Inject constructor(private val dao: UserDAO) {
    fun getRandomUserList(): List<CacheUserModel> = dao.getUserList()

    fun getUserInfoById(id: String): CacheUserModel? = dao.getByID(id)
    fun isEmptyDatabase(): Boolean = dao.getRowCount() == 0

    fun saveList(list: List<CacheUserModel>) {
        dao.deleteAll()
        dao.insertAll(list)
    }
}