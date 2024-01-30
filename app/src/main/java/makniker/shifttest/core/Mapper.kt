package makniker.shifttest.core

import makniker.shifttest.data.datamodels.CacheUserDataModel
import makniker.shifttest.data.datamodels.UserNetworkDataModel
import makniker.shifttest.presentation.ui.user.UserModel
import makniker.shifttest.presentation.ui.userlist.UserUIListModel

object Mapper {
    fun cacheToUI(cacheUserDataModel: CacheUserDataModel): UserUIListModel = UserUIListModel(
        cacheUserDataModel.id,
        cacheUserDataModel.name,
        cacheUserDataModel.picture.large,
        cacheUserDataModel.location.toUIString(),
        cacheUserDataModel.phone
    )

    fun cacheToModel(cacheUserDataModel: CacheUserDataModel): UserModel = UserModel(
        cacheUserDataModel.id,
        cacheUserDataModel.name,
        cacheUserDataModel.picture.large,
        cacheUserDataModel.location.coordinates,
        cacheUserDataModel.email,
        cacheUserDataModel.location.toString(),
        cacheUserDataModel.phone
    )

    fun networkToUI(networkDataModel: UserNetworkDataModel): UserUIListModel = UserUIListModel(
        "${networkDataModel.id.name} ${networkDataModel.id.value}",
        "${networkDataModel.name.title} ${networkDataModel.name.first} ${networkDataModel.name.last}",
        networkDataModel.picture.large,
        networkDataModel.location.toUIString(),
        networkDataModel.phone
    )

    fun networkToCache(networkDataModel: UserNetworkDataModel): CacheUserDataModel =
        CacheUserDataModel(
            "${networkDataModel.id.name} ${networkDataModel.id.value}",
            "${networkDataModel.name.title} ${networkDataModel.name.first} ${networkDataModel.name.last}",
            networkDataModel.location,
            networkDataModel.email,
            networkDataModel.phone,
            networkDataModel.picture
        )
}