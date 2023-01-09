package com.test.githubsearch.core.modules

import com.test.githubsearch.core.network.RepositoryApi
import com.test.githubsearch.repo.RepoRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteSourceModule {
    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRepoRemoteSource(repositoryApi: RepositoryApi) =
        RepoRemoteSource(repositoryApi)
}