package makniker.shifttest.di

import android.content.Context
import dagger.Module
import dagger.Provides
import makniker.shifttest.Application

@Module
open class ApplicationModule {
    @Provides
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }
}