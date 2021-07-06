package com.test.githubsearch.repo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Owner(
    @SerializedName("id")
    val id: Long,
    @SerializedName("login")
    val login: String = "",
    @SerializedName("node_id")
    val nodeId: String = "",
    @SerializedName("avatar_url")
    val avatarUrl: String? = "",
    @SerializedName("gravatar_id")
    val gravatarId: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("html_url")
    val htmlUrl: String? = "",
    @SerializedName("followers_url")
    val followersUrl: String? = "",
    @SerializedName("following_url")
    val followingUrl: String? = ""

): Serializable