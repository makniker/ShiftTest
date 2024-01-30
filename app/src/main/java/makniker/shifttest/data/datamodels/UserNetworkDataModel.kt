package makniker.shifttest.data.datamodels

import com.google.gson.annotations.SerializedName

data class UserNetworkDataModel(
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
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
    @SerializedName("coordinates") val coordinates: Coordinates,
) {
    override fun toString(): String =
        "Country: $country\nState: $state\nCity: $city\nStreet: ${street.name + ", " + street.number}"

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

data class Id(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String,
)

data class Picture(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String,
)