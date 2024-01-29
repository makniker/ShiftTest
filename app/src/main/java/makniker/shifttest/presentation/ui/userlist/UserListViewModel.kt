package makniker.shifttest.presentation.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import makniker.shifttest.core.ResponseStates
import makniker.shifttest.data.repository.UserRepository
import javax.inject.Inject

class UserListViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _userLiveData = MutableLiveData<ResponseStates<List<UserUIListModel>>>()
    val userLiveData: LiveData<ResponseStates<List<UserUIListModel>>> = _userLiveData

    fun fetchCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            _userLiveData.postValue(ResponseStates.Loading())
            try {
                _userLiveData.postValue(ResponseStates.Success(repository.getRandomUserList()))
            } catch(e: Exception) {
                _userLiveData.postValue(ResponseStates.Failure(e))
            }
        }
    }

    fun updateCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            _userLiveData.postValue(ResponseStates.Loading())
            try {
                _userLiveData.postValue(ResponseStates.Success(repository.getNewUserList()))
            } catch(e: Exception) {
                _userLiveData.postValue(ResponseStates.Failure(e))
            }
        }
    }
}