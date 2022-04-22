package com.example.githubdata.closedmr

import com.example.githubdomain.IClosedMr
import com.example.githubdomain.IUser

data class GithubClosedMr(
    override val mrTitle: String?,
    override val closedAt: String?,
    override val createdAt: String?,
    override val userData: IUser?
) : IClosedMr

data class GithubUser(
    override val userName: String?,
    override val userImage: String?
) : IUser