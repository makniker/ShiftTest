package makniker.shifttest.data

import makniker.shifttest.data.models.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("api")
    suspend fun getUsers(@Query("results") numOfUsers: Int): BaseResponse
}