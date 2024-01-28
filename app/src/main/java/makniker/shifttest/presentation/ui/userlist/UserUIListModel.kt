package makniker.shifttest.presentation.ui.userlist

import makniker.shifttest.data.models.Id

data class UserUIListModel(
    val id: Id, val name: String, val picture: String, val location: String, val phone: String
)
