package com.example.core

import android.app.Application
import android.content.Context

/**
 * @author zhe.chen
 * @date 2020/8/23 19:28
 * Des:
 */
class BaseApplication : Application() {


    companion object {
        private var currentApplication: Context? = null

        fun currentApplication(): Context {
            return currentApplication!!
        }
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }

}