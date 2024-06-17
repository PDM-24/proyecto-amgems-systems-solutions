package com.alvarado.backpack

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarado.backpack.domain.LoginUseCase
import com.alvarado.backpack.domain.RegisterUseCase
import com.alvarado.backpack.domain.WhoamiUseCase
import com.alvarado.backpack.domain.model.LoginModel
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
    private val registerUseCase : RegisterUseCase
    private val whoamiUseCase : WhoamiUseCase
) : ViewModel() {

    private val _user = MutableStateFlow(UserModel())
    val user : StateFlow<UserModel> = _user.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Ready)
    val uiState : StateFlow<UiState> = _uiState

    val loginViewModel = LoginModel()
    val registerViewModel = RegisterModel()

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
}

sealed class UiState {
    data class Success(val token: String): UiState()
    data class Error(val code: Int) : UiState()
    data object Ready : UiState()
    data object Loading : UiState()
}