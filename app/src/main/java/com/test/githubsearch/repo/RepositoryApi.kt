package com.test.githubsearch.repo

import com.test.githubsearch.core.response.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryApi {
    @GET("search")
    suspend fun searchRepositories(
        @Query("q") searchQuery: String?,
        @Query("type") type: String?,
    ): Response<ApiResponse<List<Repository>>>
}