package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.example.lesson.entity.State
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * @author zhe.chen
 * @date 2020/8/23 19:35
 * Des:
 */
class LessonPresenter {

    private val LESSON_PATH = "lessons"

    private var activity: LessonActivity? = null

    fun LessonPresenter(activity: LessonActivity?) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        HttpClient.INSTANCE.get(LESSON_PATH, type, object : EntityCallback<List<Lesson?>?> {

            override fun onSuccess(entity: List<Lesson?>?) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity?.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread { Utils.toast(message) }
            }

        })
    }

    fun showPlayback() {
        val playbackLessons: MutableList<Lesson> = ArrayList()
        for (lesson in lessons) {
            if (lesson.state === State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity?.showResult(playbackLessons)
    }

}