package com.maochunjie.mhwanalytics

import android.app.Application
import android.os.Bundle
import com.facebook.react.bridge.*
import com.huawei.agconnect.common.network.AccessNetworkManager
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance


class MhwAnalyticsModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "MhwAnalytics"
    }

    @ReactMethod
    fun initSDK() {
        if (instance == null) {
            setAccessNetwork()
            initializeSDK(applicationContext)
        }
    }

    @ReactMethod
    fun onEvent(event: String, rMap: ReadableMap, promise: Promise) {
        try {
            val bundle = mapToBundle(rMap)
            instance?.onEvent(event, bundle)
        } catch (e: IllegalArgumentException) {
        }
    }

    private fun mapToBundle(map: ReadableMap?): Bundle {
        val bundle = Bundle()
        if (map == null) {
            return bundle
        }
        val keySetIterator = map.keySetIterator()
        while (keySetIterator.hasNextKey()) {
            val key = keySetIterator.nextKey()
            when (map.getType(key)) {
                ReadableType.Null -> {}
                ReadableType.Boolean -> bundle.putBoolean(key, map.getBoolean(key))
                ReadableType.Number -> bundle.putDouble(key, map.getDouble(key))
                ReadableType.String -> bundle.putString(key, map.getString(key))
                ReadableType.Map -> {}
                ReadableType.Array -> {
                    val rArray = map.getArray(key)!!
                    val listBundle = bundleArrayList(rArray)
                    bundle.putParcelableArrayList("items", listBundle)
                }
                else -> {}
            }
        }
        return bundle
    }

    private fun bundleArrayList(rArray: ReadableArray?): ArrayList<Bundle> {
        val bundleArrayList: ArrayList<Bundle> = ArrayList()
        for (i in 0 until rArray!!.size()) {
            val map = rArray.getMap(i)
            val bundle = mapToBundle(map)
            bundleArrayList.add(bundle)
        }
        return bundleArrayList
    }

    companion object {
        var instance: HiAnalyticsInstance? = null
        var applicationContext: Application? = null

        @JvmStatic
        fun preInitializeSDK(application: Application) {
            applicationContext = application
        }

        @JvmStatic
        fun initializeSDK(application: Application?) {
            instance = HiAnalytics.getInstance(application)
        }

        @JvmStatic
        fun setAccessNetwork() {
            AccessNetworkManager.getInstance().setAccessNetwork(true)
        }
    }
}
