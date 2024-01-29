package makniker.shifttest.core

import makniker.shifttest.data.database.CacheUserModel
import makniker.shifttest.data.models.UserNetworkDataModel
import makniker.shifttest.presentation.ui.userlist.UserUIListModel

object Mapper {
    fun cacheToUI(cacheUserModel: CacheUserModel): UserUIListModel = UserUIListModel(
        cacheUserModel.id,
        cacheUserModel.name,
        cacheUserModel.picture.large,
        cacheUserModel.location.country,
        cacheUserModel.phone
    )

    fun networkToUI(networkDataModel: UserNetworkDataModel): UserUIListModel = UserUIListModel(
        "${networkDataModel.id.name} ${networkDataModel.id.value}",
        "${networkDataModel.name.title} ${networkDataModel.name.first} ${networkDataModel.name.last}",
        networkDataModel.picture.large,
        networkDataModel.location.country,
        networkDataModel.phone
    )

    fun networkToCache(networkDataModel: UserNetworkDataModel): CacheUserModel = CacheUserModel(
        "${networkDataModel.id.name} ${networkDataModel.id.value}",
        "${networkDataModel.name.title} ${networkDataModel.name.first} ${networkDataModel.name.last}",
        networkDataModel.gender,
        networkDataModel.location,
        networkDataModel.email,
        networkDataModel.login,
        networkDataModel.phone,
        networkDataModel.cell,
        networkDataModel.picture
    )
}