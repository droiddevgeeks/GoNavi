package com.example.githubdata.models

import com.google.gson.annotations.SerializedName

/**
 * Title, Created date, closed date, userName, user Image
 */
data class ClosedMr(
    @SerializedName("title")
    val mrTitle: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("closed_at")
    val closedAt: String?,
    @SerializedName("user")
    val userData: User
)

/**
 * userName, user Image
 */
data class User(
    @SerializedName("login")
    val userName: String?,
    @SerializedName("avatar_url")
    val userImage: String?
)