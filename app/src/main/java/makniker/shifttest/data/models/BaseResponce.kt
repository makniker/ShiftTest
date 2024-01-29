package makniker.shifttest.data.models

import com.google.gson.annotations.SerializedName

class BaseResponse(
    @SerializedName("results") val results: List<UserNetworkDataModel>
)

data class UserNetworkDataModel(
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String,
    @SerializedName("login") val login: Login,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: Id,
    @SerializedName("picture") val picture: Picture,
)

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
) {
    override fun toString(): String =
        "Country: $country\n State: $state\n City: $city\n Street: $street"

    fun toUIString(): String = "$country, $city"
}

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

data class Login(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
)

