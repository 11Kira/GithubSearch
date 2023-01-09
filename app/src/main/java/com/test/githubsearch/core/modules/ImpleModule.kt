package com.test.githubsearch.core.modules

import com.test.githubsearch.repo.RepoRemoteSource
import com.test.githubsearch.repo.RepoRepositoryImpl
import org.koin.dsl.module

val implModule = module {
    factory { provideRepoImpl(get()) }
}

fun provideRepoImpl(repoRemoteSource: RepoRemoteSource) = RepoRepositoryImpl(repoRemoteSource)