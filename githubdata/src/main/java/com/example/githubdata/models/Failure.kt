package com.example.githubdata.models

import com.example.githubdomain.common.ErrorModel
import com.example.githubdomain.common.IFailure

sealed class Failure(override val errorModel: ErrorModel) : IFailure {
    class HttpError(error: ErrorModel) : Failure(error)
    class DisplayableError(error: ErrorModel) : Failure(error)
}
