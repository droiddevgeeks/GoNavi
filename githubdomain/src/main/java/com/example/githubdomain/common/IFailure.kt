package com.example.githubdomain.common

interface IFailure {
    val errorModel: ErrorModel
}

data class ErrorModel(
    val errorMsg: String? = null,
    val errorCode: Any? = null,
)