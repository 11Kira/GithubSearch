package com.test.githubsearch

import android.app.Application
import com.test.githubsearch.core.modules.apiModule
import com.test.githubsearch.core.modules.implModule
import com.test.githubsearch.core.modules.repositoryModule
import com.test.githubsearch.core.modules.retrofitModule
import com.test.githubsearch.core.modules.useCaseModule
import com.test.githubsearch.core.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Application class to initialize 3rd party integrations.
 * @author Julius Villagracia
 */
class GithubSearchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GithubSearchApp)
            modules(
                implModule,
                useCaseModule,
                viewModelModule,
                repositoryModule,
                retrofitModule,
                apiModule
            )
        }
    }
}