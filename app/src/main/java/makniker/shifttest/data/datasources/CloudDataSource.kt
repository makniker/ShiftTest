package makniker.shifttest.data.datasources

import makniker.shifttest.data.NetworkService
import makniker.shifttest.data.models.UserNetworkDataModel
import javax.inject.Inject

class CloudDataSource @Inject constructor(private val service: NetworkService) {

    private var numOfUsers : Int = 10

    suspend fun getRandomUserList(numOfUsers: Int): List<UserNetworkDataModel> {
        this.numOfUsers = numOfUsers
        return service.getUsers(this.numOfUsers).results
    }

    suspend fun update(): List<UserNetworkDataModel> {
        return service.getUsers(numOfUsers).results
    }
}