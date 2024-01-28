package makniker.shifttest.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import makniker.shifttest.data.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_ENDPOINT = "https://randomuser.me/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .create()


    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): NetworkService =
        retrofit.create(NetworkService::class.java)
}