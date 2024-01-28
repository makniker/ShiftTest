package makniker.shifttest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import makniker.shifttest.data.NetworkService
import makniker.shifttest.data.datasources.CacheDataSource
import makniker.shifttest.data.datasources.CloudDataSource
import javax.inject.Singleton

@Module
class StorageModule {
    @Provides
    @Singleton
    fun provideCacheDataSource(): CacheDataSource =
        CacheDataSource()

    @Provides
    @Singleton
    fun provideCloudDataSource(networkService: NetworkService): CloudDataSource =
        CloudDataSource(networkService)
}