package com.example.githubdata.closedmr

import com.example.githubdata.network.GithubApi
import com.example.githubdata.network.apiCall
import com.example.githubdomain.IClosedMr
import com.example.githubdomain.IGithubRepository
import com.example.githubdomain.common.IFailure
import com.example.githubdomain.common.Result
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val apiService: GithubApi
) : IGithubRepository {

    override suspend fun getAllClosedMR(): Result<IFailure, List<IClosedMr>> {
        return apiCall(
            apiCall = { apiService.getGithubClosedMr() },
            successTransform = { it.toGithubClosedMr() }
        )
    }
}