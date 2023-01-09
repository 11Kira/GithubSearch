package com.test.githubsearch.core.modules

import com.test.githubsearch.repo.RepoRepositoryImpl
import com.test.githubsearch.repo.RepoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { provideRepoUseCase(get()) }
}

fun provideRepoUseCase(repoRepositoryImpl: RepoRepositoryImpl) = RepoUseCase(repoRepositoryImpl)