package makniker.shifttest.data.datasources

import makniker.shifttest.data.models.UserDataModel

interface DataSource {
    suspend fun getRandomUserList(numOfUsers: Int): List<UserDataModel>
}