package makniker.shifttest.data.datasources

import makniker.shifttest.data.NetworkService
import makniker.shifttest.data.models.UserDataModel
import javax.inject.Inject

class CloudDataSource @Inject constructor(private val service: NetworkService) : DataSource {

    private var numOfUsers : Int = 10

    override suspend fun getRandomUserList(numOfUsers: Int): List<UserDataModel> {
        this.numOfUsers = numOfUsers
        return service.getUsers(this.numOfUsers).results
    }

    suspend fun update(): List<UserDataModel> {
        return service.getUsers(numOfUsers).results
    }
}