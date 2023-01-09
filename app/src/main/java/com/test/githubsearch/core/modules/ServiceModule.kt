package com.test.githubsearch.core.modules

import com.test.githubsearch.core.network.RepositoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Singleton
    @Provides
    fun provideRepoService(retrofit: Retrofit): RepositoryApi = retrofit.create(RepositoryApi::class.java)

}