package com.test.githubsearch.core.modules

import com.test.githubsearch.repo.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RepositoryViewModel() }
}