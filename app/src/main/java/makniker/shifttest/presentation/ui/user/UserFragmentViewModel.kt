package makniker.shifttest.presentation.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import makniker.shifttest.core.ResponseStates
import makniker.shifttest.data.repository.UserRepository
import javax.inject.Inject

class UserFragmentViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _userLiveData = MutableLiveData<ResponseStates<UserModel>>()
    val userLiveData: LiveData<ResponseStates<UserModel>> = _userLiveData

    fun getUserInfoById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _userLiveData.postValue(ResponseStates.Loading())
            try {
                val user = repository.getUserInfoById(id)
                _userLiveData.postValue(ResponseStates.Success(user))
            } catch(e: Exception) {
                _userLiveData.postValue(ResponseStates.Failure(e))
            }
        }
    }
}