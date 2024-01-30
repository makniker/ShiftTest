package makniker.shifttest.data.datasources

import makniker.shifttest.data.datamodels.CacheUserDataModel
import makniker.shifttest.data.database.UserDAO
import javax.inject.Inject

class CacheDataSource @Inject constructor(private val dao: UserDAO) {
    fun getRandomUserList(): List<CacheUserDataModel> = dao.getUserList()

    fun getUserInfoById(id: String): CacheUserDataModel? = dao.getByID(id)
    fun isEmptyDatabase(): Boolean = dao.getRowCount() == 0

    fun saveList(list: List<CacheUserDataModel>) {
        dao.deleteAll()
        dao.insertAll(list)
    }
}