package makniker.shifttest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import makniker.shifttest.presentation.ui.user.UserFragmentViewModel
import makniker.shifttest.presentation.ui.userlist.UserListViewModel
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    abstract fun userListViewModel(userListViewModel: UserListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserFragmentViewModel::class)
    abstract fun userViewModel(userFragmentViewModel: UserFragmentViewModel): ViewModel
}