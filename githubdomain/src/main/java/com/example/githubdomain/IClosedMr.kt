package com.example.githubdomain

interface IClosedMr {
    val mrTitle: String?
    val createdAt: String?
    val closedAt: String?
    val userData: IUser?
}

interface IUser {
    val userName: String?
    val userImage: String?
}