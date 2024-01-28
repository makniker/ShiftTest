package makniker.shifttest.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import makniker.shifttest.Application
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        FragmentModule::class,
        StorageModule::class,
    ]
)

interface ApplicationComponent : AndroidInjector<Application> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Application): ApplicationComponent
    }
}