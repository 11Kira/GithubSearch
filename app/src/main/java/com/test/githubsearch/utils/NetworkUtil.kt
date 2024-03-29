package com.test.githubsearch.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.githubsearch.R
import com.test.githubsearch.core.base.BaseActivity
import kotlinx.serialization.ExperimentalSerializationApi

/**
 * Utility class to be used for network related calls
 * @author Julius Villagracia
 */
object NetworkUtil {

    /**
     * Checks for internet connectivity and display alert to open internet settings
     * @param activity The reference to activity to access the alert functions
     * @param action The api request function to be executed when the user has internet connection
     */
    fun checkInternetConnectivity(activity: BaseActivity, action: () -> Unit,) {
        if (isNetworkConnected(activity)) {
            action.invoke()
        } else {
            activity.showAlert(
                activity.getString(R.string.no_connectivity),
                activity.getString(R.string.err_no_network),
                R.string.btn_settings,
                { openInternetSettings(activity) },
                R.string.btn_close,
                { activity.finishAffinity() },
            )
        }
    }

    /**
     * Checks for internet connectivity
     * @param context The context reference
     */
    private fun isNetworkConnected(context: Context) : Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =  connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        capabilities.also {
            if (it != null){
                if (it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
                    return true
                else if (it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                    return true
                }
            }
        }
        return false
    }

    /**
     * Launches the phones internet settings
     * @param context The context reference
     */
    private fun openInternetSettings(context: Context) {
        context.startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
    }

    @ExperimentalSerializationApi
    fun json(): Gson = GsonBuilder().apply {
        setLenient()
    }.create()
}