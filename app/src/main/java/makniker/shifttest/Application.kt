package makniker.shifttest

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import makniker.shifttest.di.DaggerApplicationComponent

class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }
}