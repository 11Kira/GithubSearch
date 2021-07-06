package com.test.githubsearch.core

import android.content.Context
import androidx.lifecycle.ViewModel
import com.test.githubsearch.core.network.ResponseCodes
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseViewModel : ViewModel(), KoinComponent {

    protected val applicationContext: Context by inject()

    protected fun getGenericError(errorCode: Int): String {
        return when (errorCode) {
            ResponseCodes.SOCKET_TIMEOUT.code -> ResponseCodes.SOCKET_TIMEOUT.name
            ResponseCodes.NOT_FOUND.code -> ResponseCodes.NOT_FOUND.name
            ResponseCodes.INTERNAL_SERVER_ERROR.code -> ResponseCodes.INTERNAL_SERVER_ERROR.name
            ResponseCodes.BAD_REQUEST.code -> ResponseCodes.BAD_REQUEST.name
            ResponseCodes.NOT_IMPLEMENTED.code -> ResponseCodes.NOT_IMPLEMENTED.name
            ResponseCodes.BAD_GATEWAY.code -> ResponseCodes.BAD_GATEWAY.name
            ResponseCodes.SERVICE_UNAVAILABLE.code -> ResponseCodes.SERVICE_UNAVAILABLE.name
            ResponseCodes.GATEWAY_TIMEOUT.code -> ResponseCodes.GATEWAY_TIMEOUT.name
            else -> ResponseCodes.UNKNOWN_ERROR.name
        }
    }

    protected fun getString(resId: Int): String {
        return applicationContext.getString(resId)
    }

}