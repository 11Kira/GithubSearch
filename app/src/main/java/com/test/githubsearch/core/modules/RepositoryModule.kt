package com.test.githubsearch.core.modules

import com.test.githubsearch.repo.RepositoryApi
import com.test.githubsearch.repo.RepositoryResultsRepo
import org.koin.dsl.module

val repositoryModule = module {
    factory { provideRepositoryRepo(get()) }
}

fun provideRepositoryRepo(repositoryApi: RepositoryApi) = RepositoryResultsRepo(repositoryApi)