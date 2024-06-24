package com.alvarado.backpack

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarado.backpack.domain.FavoritePostUseCase
import com.alvarado.backpack.domain.GetAllPostsUseCase
import com.alvarado.backpack.domain.GetOwnPostsUseCase
import com.alvarado.backpack.domain.GetPostsBySubjectUseCase
import com.alvarado.backpack.domain.GetSavedPostsUseCase
import com.alvarado.backpack.domain.GetSubjectByDegreeUseCase
import com.alvarado.backpack.domain.LoginUseCase
import com.alvarado.backpack.domain.RegisterUseCase
import com.alvarado.backpack.domain.WhoamiUseCase
import com.alvarado.backpack.domain.model.LoginModel
import com.alvarado.backpack.domain.model.PostModel
import com.alvarado.backpack.domain.model.RegisterModel
import com.alvarado.backpack.domain.model.SubjectModel
import com.alvarado.backpack.domain.model.UserModel
import com.alvarado.backpack.util.TokenManager
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
    private val getPostsBySubjectUseCase : GetPostsBySubjectUseCase,
    private val favoritePostUseCase : FavoritePostUseCase,
    private val getSubjectByDegreeUseCase : GetSubjectByDegreeUseCase,
    private val tokenManager : TokenManager
) : ViewModel() {

    private val _user = MutableStateFlow(UserModel())
    val user : StateFlow<UserModel> = _user.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Ready)
    val uiState : StateFlow<UiState> = _uiState

    private val _postListAll = MutableStateFlow(listOf<PostModel>())
    val postListAll = _postListAll.asStateFlow()

    private val _postListFavorite = MutableStateFlow(listOf<PostModel>())
    val postListFavorite = _postListFavorite.asStateFlow()

    private val _postListOwn = MutableStateFlow(listOf<PostModel>())
    val postListOwn = _postListOwn.asStateFlow()

    private val _postListByDegree = MutableStateFlow(listOf<PostModel>())
    val postListByDegree = _postListByDegree.asStateFlow()

    private val _subjectList = MutableStateFlow(listOf<SubjectModel>())
    val subjectList = _subjectList.asStateFlow()

    private val subjectSelected = MutableStateFlow("")

    fun getSubjectSelected() : String {
        return subjectSelected.value
    }

    fun setSubjectSelected(subject : String) {
        subjectSelected.value = subject
    }

    fun setStateToReady() {
        _uiState.value = UiState.Ready
    }

    fun login(loginModel : LoginModel) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                val token = loginUseCase.invoke(loginModel)
                tokenManager.saveToken(token)
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

    fun whoami() {
        viewModelScope.launch {
            try {
                tokenManager.token.collect { token ->
                    _user.value = whoamiUseCase.invoke("Bearer $token")
                }
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getAllPosts() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                tokenManager.token.collect { token ->
                    _postListAll.value = getAllPostsUseCase.invoke("Bearer $token")
                    _uiState.value = UiState.Success("Bearer $token")
                }
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getSavedPosts() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                tokenManager.token.collect { token ->
                    _postListFavorite.value = getSavedPostsUseCase.invoke("Bearer $token")
                    _uiState.value = UiState.Success("Bearer $token")
                }
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getOwnPosts() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                tokenManager.token.collect { token ->
                    _postListAll.value = getOwnPostsUseCase.invoke("Bearer $token")
                    _uiState.value = UiState.Success("Bearer $token")
                }
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun getPostBySubject(subjectId : String) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                tokenManager.token.collect { token ->
                    _postListByDegree.value = getPostsBySubjectUseCase.invoke("Bearer $token", subjectId)
                    _uiState.value = UiState.Success("Bearer $token")
                }
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }

    fun favoritePost(postId : String) {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                tokenManager.token.collect { token ->
                    favoritePostUseCase.invoke("Bearer $token", postId)
                    _uiState.value = UiState.Success("Bearer $token")
                }
            } catch (e : HttpException) {
                Log.d("viewModel", "Error! ${e.message()}")
                _uiState.value = UiState.Error(e.code())
            }
        }
    }
    
    fun getSubjectByDegree() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                tokenManager.token.collect { token ->
                    _subjectList.value = getSubjectByDegreeUseCase.invoke("Bearer $token")
                    _uiState.value = UiState.Success("Bearer $token")
                }
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