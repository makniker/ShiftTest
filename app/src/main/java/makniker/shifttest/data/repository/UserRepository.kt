package makniker.shifttest.data.repository

import makniker.shifttest.data.datasources.CacheDataSource
import makniker.shifttest.data.datasources.CloudDataSource
import makniker.shifttest.data.models.UserDataModel
import makniker.shifttest.presentation.ui.userlist.UserUIListModel
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val cloudDataSource: CloudDataSource,
    private val cacheDataSource: CacheDataSource
) {
    suspend fun getRandomUserList(): List<UserUIListModel> {
        if (cacheDataSource.isEmptyDatabase()) {
            return cloudDataSource.getRandomUserList(10)
                .map {
                    it.to()
                }
        }
        return cacheDataSource.getRandomUserList(10).map {
            it.to()
        }
    }

    suspend fun getUserInfoById(id: String): UserDataModel {
        TODO()
    }
}