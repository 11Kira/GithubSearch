package com.test.githubsearch.repo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Repository(
    @SerializedName("id")
    val id: Long,
    @SerializedName("node_id")
    val nodeId: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("full_name")
    val fullName: String? = "",
    @SerializedName("private")
    val private: String? = "",
    @SerializedName("owner")
    val owner: Owner? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("language")
    val language: String? = "",
    @SerializedName("stargazers_count")
    val stargazersCount: Int

): Serializable