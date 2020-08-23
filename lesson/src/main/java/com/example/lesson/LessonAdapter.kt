package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson
import com.example.lesson.entity.State
import java.util.*

/**
 * @author zhe.chen
 * @date 2020/8/23 19:40
 * Des:
 */
class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var list: List<Lesson> = ArrayList()

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder = LessonViewHolder.onCreate(parent);

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) = holder.onBind(list[position])

    /**
     * 静态内部类
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        fun onBind(lesson: Lesson) {
            var date = lesson.date
            if (date == null) {
                date = "日期待定"
            }
            setText(R.id.tv_date, date)
            setText(R.id.tv_content, lesson.content)
            val state = lesson.state
            if (state != null) {
                setText(R.id.tv_state, state.stateName())
                var colorRes = R.color.playback
                colorRes = when (state) {
                    State.PLAYBACK -> {

                        // 即使在 {} 中也是需要 break 的。
                        R.color.playback
                    }
                    State.LIVE -> R.color.live
                    State.WAIT -> R.color.wait
                }
                val backgroundColor: Int = itemView.getContext().getColor(colorRes)
                getView<TextView>(R.id.tv_state)?.setBackgroundColor(backgroundColor)
            }
        }

        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false))
            }
        }
    }
}