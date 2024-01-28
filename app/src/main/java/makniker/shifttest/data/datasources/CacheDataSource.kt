package makniker.shifttest.data.datasources

import makniker.shifttest.data.models.UserDataModel

class CacheDataSource : DataSource {
    override suspend fun getRandomUserList(numOfUsers: Int): List<UserDataModel> {
        TODO("Not yet implemented")
    }

    fun getUserInfoById(id: String): UserDataModel {
        TODO("Not yet implemented")
    }

    fun isUserPresentInDatabase(id: String): Boolean {
        TODO("Not yet implemented")
    }

    fun isEmptyDatabase() : Boolean = true
}