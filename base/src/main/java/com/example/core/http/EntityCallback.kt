package com.example.core.http

/**
 * @author zhe.chen
 * @date 2020/8/23 19:31
 * Des:
 */
interface EntityCallback<T> {

    fun onSuccess(entity: T)

    fun onFailure(message: String?)

}