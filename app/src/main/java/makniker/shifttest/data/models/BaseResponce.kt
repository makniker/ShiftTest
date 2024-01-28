package makniker.shifttest.data.models

import com.google.gson.annotations.SerializedName
import makniker.shifttest.core.Mapper
import makniker.shifttest.presentation.ui.userlist.UserUIListModel

class BaseResponse(
    @SerializedName("results") val results: List<UserDataModel>,
    @SerializedName("info") val info: Info,
)

data class UserDataModel(
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: Id,
    @SerializedName("picture") val picture: Picture,
) : Mapper<UserUIListModel> {
    override fun to(): UserUIListModel =
        UserUIListModel(id,
            name.title + " " + name.first + " " + name.last,
            picture.large,
            location.country,
            phone
        )
    }

data class Name(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String,
)

data class Location(
    @SerializedName("street") val street: Street,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("postcode") val postcode: String,
    @SerializedName("coordinates") val coordinates: Coordinates,
    @SerializedName("timezone") val timezone: Timezone,
)

data class Street(
    @SerializedName("number") val number: Long,
    @SerializedName("name") val name: String,
)

data class Coordinates(
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String,
)

data class Timezone(
    @SerializedName("offset") val offset: String,
    @SerializedName("description") val description: String,
)

data class Id(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String,
)

data class Picture(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String,
)

data class Info(
    @SerializedName("seed") val seed: String,
    @SerializedName("results") val results: Long,
    @SerializedName("page") val page: Long,
    @SerializedName("version") val version: String,
)
