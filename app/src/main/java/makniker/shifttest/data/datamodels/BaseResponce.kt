package makniker.shifttest.data.datamodels

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("results") val results: List<T>
)

