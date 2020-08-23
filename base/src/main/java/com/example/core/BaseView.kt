package com.example.core

/**
 * @author zhe.chen
 * @date 2020/8/23 19:29
 * Des:
 */
interface BaseView<T> {
    fun getPresenter(): T
}