package com.test.githubsearch.core.modules

import com.test.githubsearch.repo.RepoRemoteSource
import com.test.githubsearch.repo.RepositoryApi
import org.koin.dsl.module

val repositoryModule = module {
    factory { provideRepositoryRepo(get()) }
}

fun provideRepositoryRepo(repositoryApi: RepositoryApi) = RepoRemoteSource(repositoryApi)