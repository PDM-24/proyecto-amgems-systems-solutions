package com.alvarado.backpack

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarado.backpack.domain.GetAllPostsUseCase
import com.alvarado.backpack.domain.GetOwnPostsUseCase
import com.alvarado.backpack.domain.GetPostsBySubjectUseCase
import com.alvarado.backpack.domain.GetSavedPostsUseCase
import com.alvarado.backpack.domain.LoginUseCase
import com.alvarado.backpack.domain.RegisterUseCase
import com.alvarado.backpack.domain.WhoamiUseCase
import com.alvarado.backpack.domain.model.LoginModel
import com.alvarado.backpack.domain.model.PostModel
import com.alvarado.backpack.domain.model.RegisterModel
import com.alvarado.backpack.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginUseCase : LoginUseCase,
    private val registerUseCase : RegisterUseCase,
    private val whoamiUseCase : WhoamiUseCase,
    private val getAllPostsUseCase : GetAllPostsUseCase,
    private val getOwnPostsUseCase : GetOwnPostsUseCase,
    private val getSavedPostsUseCase : GetSavedPostsUseCase,
    private val getPostsBySubject : GetPostsBySubjectUseCase,
) : ViewModel() {

    private val _user = MutableStateFlow(UserModel())
    val user : StateFlow<UserModel> = _user.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Ready)
    val uiState : StateFlow<UiState> = _uiState

    private val _postList = MutableStateFlow(listOf<PostModel>())
    val postList = _postList.asStateFlow()


    fun setStateToReady() {
        _uiState.value = UiState.Ready
    }

    fun login(loginModel : LoginModel) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                val token = loginUseCase.invoke(loginModel)
                _uiState.value = UiState.Success(token)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun register(registerModel : RegisterModel) {
        if (!validateRegisterModel(registerModel)) {
            _uiState.value = UiState.Error(400)
            return
        }

        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                val message = registerUseCase.invoke(registerModel)
                _uiState.value = UiState.Success(message)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun whoami(token : String) {
        viewModelScope.launch {
            try {
                _user.value = whoamiUseCase.invoke(token)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getAllPosts(token : String) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                _postList.value = getAllPostsUseCase.invoke(token)
                _uiState.value = UiState.Success(token)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getSavedPosts(token : String) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                _postList.value = getSavedPostsUseCase.invoke(token)
                _uiState.value = UiState.Success(token)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getOwnPosts(token : String) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                _postList.value = getOwnPostsUseCase.invoke(token)
                _uiState.value = UiState.Success(token)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getPostBySubject(token : String, subjectId : String) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                _postList.value = getPostsBySubject.invoke(token, subjectId)
                _uiState.value = UiState.Success(token)
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    private fun validateRegisterModel(registerModel: RegisterModel): Boolean {
        return registerModel.carnet.isNotBlank() &&
                registerModel.name.isNotBlank() &&
                registerModel.lastname.isNotBlank() &&
                registerModel.email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(registerModel.email).matches() &&
                registerModel.degree.isNotBlank() &&
                registerModel.password.isNotBlank() && registerModel.password.length >= 8
    }

    fun resetUiState() {
        _uiState.value = UiState.Idle
    }
}

sealed class UiState {
    data class Success(val token: String): UiState()
    data class Error(val code: Int) : UiState()
    data object Ready : UiState()
    data object Loading : UiState()

    object Idle : UiState()
}