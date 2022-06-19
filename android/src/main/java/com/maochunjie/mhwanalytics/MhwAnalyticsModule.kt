package com.maochunjie.mhwanalytics

import android.app.Application
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.huawei.agconnect.common.network.AccessNetworkManager
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance

class MhwAnalyticsModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "MhwAnalytics"
    }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    fun multiply(a: Int, b: Int, promise: Promise) {
        promise.resolve(a * b)
    }

    companion object {
        var instance: HiAnalyticsInstance? = null

        @JvmStatic
        fun initializeSDK(application: Application) {
            instance = HiAnalytics.getInstance(application)
        }

        @JvmStatic
        fun setAccessNetwork() {
            AccessNetworkManager.getInstance().setAccessNetwork(true)
        }
    }
}
