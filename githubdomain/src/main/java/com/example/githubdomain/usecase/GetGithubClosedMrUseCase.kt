package com.example.githubdomain.usecase

import com.example.githubdomain.IClosedMr
import com.example.githubdomain.IGithubRepository
import com.example.githubdomain.common.IFailure
import com.example.githubdomain.common.Result
import com.example.githubdomain.common.UseCase
import javax.inject.Inject

class GetGithubClosedMrUseCase @Inject constructor(
    private val githubRepository: IGithubRepository
) : UseCase<Unit, List<IClosedMr>>() {

    override suspend fun run(params: Unit): Result<IFailure, List<IClosedMr>> {
        return githubRepository.getAllClosedMR()
    }
}