package makniker.shifttest.presentation.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import makniker.shifttest.core.ResponseStates
import makniker.shifttest.data.repository.UserRepository
import makniker.shifttest.presentation.ui.user.UserModel
import javax.inject.Inject

class UserListViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _userListLiveData = MutableLiveData<ResponseStates<List<UserUIListModel>>>()
    val userListLiveData: LiveData<ResponseStates<List<UserUIListModel>>> = _userListLiveData

    fun fetchCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            _userListLiveData.postValue(ResponseStates.Loading())
            try {
                _userListLiveData.postValue(ResponseStates.Success(repository.getRandomUserList()))
            } catch(e: Exception) {
                _userListLiveData.postValue(ResponseStates.Failure(e))
            }
        }
    }

    fun updateCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            _userListLiveData.postValue(ResponseStates.Loading())
            try {
                _userListLiveData.postValue(ResponseStates.Success(repository.getNewUserList()))
            } catch(e: Exception) {
                _userListLiveData.postValue(ResponseStates.Failure(e))
            }
        }
    }
}