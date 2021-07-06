package com.test.githubsearch.core.modules

import com.test.githubsearch.repo.RepositoryApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    factory { provideRepoApi(get()) }
}

fun provideRepoApi(retrofit: Retrofit): RepositoryApi = retrofit.create(RepositoryApi::class.java)