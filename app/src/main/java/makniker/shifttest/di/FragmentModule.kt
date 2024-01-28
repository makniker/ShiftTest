package makniker.shifttest.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import makniker.shifttest.presentation.ui.user.UserFragment
import makniker.shifttest.presentation.ui.userlist.UserListFragment

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun userListFragment(): UserListFragment
    @ContributesAndroidInjector
    abstract fun userFragment(): UserFragment
}