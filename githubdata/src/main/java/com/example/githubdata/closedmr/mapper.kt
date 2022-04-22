package com.example.githubdata.closedmr

import com.example.githubdata.models.ClosedMr
import com.example.githubdata.models.User
import com.example.githubdomain.IClosedMr
import com.example.githubdomain.IUser

fun List<ClosedMr>.toGithubClosedMr(): List<IClosedMr> {
    val closedMRList = mutableListOf<GithubClosedMr>()
    this.forEach {
        closedMRList.add(
            GithubClosedMr(
                mrTitle = it.mrTitle,
                closedAt = it.closedAt,
                createdAt = it.createdAt,
                userData = it.userData.toGithubUser()
            )
        )
    }
    return closedMRList
}

fun User.toGithubUser(): IUser {
    return GithubUser(userName = userName, userImage = userImage)
}