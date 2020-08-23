package com.example.lesson.entity

/**
 * @author zhe.chen
 * @date 2020/8/23 19:45
 * Des:
 */
data class Lesson(var date: String?,
                  val content: String,
                  val state: State) {
}

enum class State {
    PLAYBACK {
        override fun stateName(): String {
            return "有回放"
        }
    },
    LIVE {
        override fun stateName(): String {
            return "正在直播"
        }
    },
    WAIT {
        override fun stateName(): String {
            return "等待中"
        }
    };

    abstract fun stateName(): String?
}