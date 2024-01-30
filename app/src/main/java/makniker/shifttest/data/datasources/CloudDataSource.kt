package makniker.shifttest.data.datasources

import makniker.shifttest.data.NetworkService
import makniker.shifttest.data.models.UserNetworkDataModel
import javax.inject.Inject

class CloudDataSource @Inject constructor(private val service: NetworkService) {

    suspend fun getRandomUserList(): List<UserNetworkDataModel> {
        return service.getUsers(7).results
    }
}