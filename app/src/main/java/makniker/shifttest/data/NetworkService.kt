package makniker.shifttest.data

import makniker.shifttest.data.datamodels.BaseResponse
import makniker.shifttest.data.datamodels.UserNetworkDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("api")
    suspend fun getUsers(@Query("results") numOfUsers: Int): BaseResponse<UserNetworkDataModel>
}