package makniker.shifttest.data.repository

import makniker.shifttest.core.Mapper
import makniker.shifttest.data.datasources.CacheDataSource
import makniker.shifttest.data.datasources.CloudDataSource
import makniker.shifttest.data.models.UserNetworkDataModel
import makniker.shifttest.presentation.ui.user.UserModel
import makniker.shifttest.presentation.ui.userlist.UserUIListModel
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val cloudDataSource: CloudDataSource, private val cacheDataSource: CacheDataSource
) {
    suspend fun getRandomUserList(): List<UserUIListModel> {
        if (cacheDataSource.isEmptyDatabase()) {
            val list = cloudDataSource.getRandomUserList()
            cacheDataSource.saveList(list.map { Mapper.networkToCache(it) })
            return list.map { Mapper.networkToUI(it) }
        }
        return cacheDataSource.getRandomUserList().map {
            Mapper.cacheToUI(it)
        }
    }

    suspend fun getNewUserList(): List<UserUIListModel> {
        val list = cloudDataSource.getRandomUserList()
        cacheDataSource.saveList(list.map { Mapper.networkToCache(it) })
        return list.map { Mapper.networkToUI(it) }
    }

    fun getUserInfoById(id: String): UserModel {
        val user = cacheDataSource.getUserInfoById(id) ?: throw Exception("Cant find user")
        return Mapper.cacheToModel(user)
    }
}