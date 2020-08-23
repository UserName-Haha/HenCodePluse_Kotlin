package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

/**
 * @author zhe.chen
 * @date 2020/8/23 19:32
 * Des:
 */
object CacheUtils {

    @SuppressLint("StaticFieldLeak")
    private val context: Context = BaseApplication.currentApplication()

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    operator fun get(key: String?): String? {
        return SP.getString(key, null)
    }

}