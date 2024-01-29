package makniker.shifttest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import makniker.shifttest.data.NetworkService
import makniker.shifttest.data.database.AppDatabase
import makniker.shifttest.data.database.UserDAO
import makniker.shifttest.data.datasources.CacheDataSource
import makniker.shifttest.data.datasources.CloudDataSource
import javax.inject.Singleton

@Module
class StorageModule {
    @Provides
    fun provideRoomDatabase(applicationContext: Context) = Room.databaseBuilder(
        applicationContext, AppDatabase::class.java, "user-list"
    )
        .build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDAO = db.userDAO()

    @Provides
    @Singleton
    fun provideCacheDataSource(dao: UserDAO): CacheDataSource = CacheDataSource(dao)

    @Provides
    @Singleton
    fun provideCloudDataSource(networkService: NetworkService): CloudDataSource =
        CloudDataSource(networkService)
}