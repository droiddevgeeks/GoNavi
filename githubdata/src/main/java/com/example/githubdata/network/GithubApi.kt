package com.example.githubdata.network

import com.example.githubdata.models.ClosedMr
import retrofit2.http.GET

interface GithubApi {

    @GET(ApiConstants.GITHUB_CLOSED_MR)
    suspend fun getGithubClosedMr(): List<ClosedMr>
}