package com.example.gonavi.views.models

import com.example.githubdomain.common.IFailure

sealed class ApiState<out T> {
    data class Loading(val isLoading: Boolean) : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Failure(val failure: IFailure) : ApiState<Nothing>()
}