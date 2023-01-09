package com.test.githubsearch.core.network

import com.test.githubsearch.model.Repository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API interface for repository related requests
 * @author Julius Villagracia
 */
interface RepositoryApi {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") searchQuery: String?,
        @Query("type") type: String?,
    ): Response<ApiResponse<List<Repository>>>
}