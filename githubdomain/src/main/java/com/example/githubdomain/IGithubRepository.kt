package com.example.githubdomain

import com.example.githubdomain.common.IFailure
import com.example.githubdomain.common.Result

interface IGithubRepository {
    suspend fun getAllClosedMR(): Result<IFailure, List<IClosedMr>>
}