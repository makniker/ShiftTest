package makniker.shifttest.presentation.ui.user

import makniker.shifttest.data.datamodels.Coordinates

data class UserModel(
    val id: String,
    val name: String,
    val picture: String,
    val coordinates: Coordinates,
    val email: String,
    val location: String,
    val phone: String,
)
