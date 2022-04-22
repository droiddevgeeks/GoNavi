package com.example.gonavi.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.githubdomain.IClosedMr
import com.example.githubdomain.usecase.GetGithubClosedMrUseCase
import com.example.gonavi.views.models.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val closedMrUseCase: GetGithubClosedMrUseCase
) : ViewModel() {

    private val _fetchClosedMRStatus: MutableLiveData<ApiState<List<IClosedMr>>> by lazy { MutableLiveData() }
    val fetchClosedMRStatus: LiveData<ApiState<List<IClosedMr>>> by lazy { _fetchClosedMRStatus }

    internal fun getAllClosedMR() {
        _fetchClosedMRStatus.value = ApiState.Loading(true)
        closedMrUseCase.invoke(
            scope = viewModelScope,
            params = Unit,
            onSuccess = {
                _fetchClosedMRStatus.value = ApiState.Loading(false)
                _fetchClosedMRStatus.value = ApiState.Success(it)
            },
            onFailure = { _fetchClosedMRStatus.value = ApiState.Failure(it) }
        )
    }
}