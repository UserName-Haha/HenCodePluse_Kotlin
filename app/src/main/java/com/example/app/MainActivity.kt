package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author zhe.chen
 * @date 2020/8/23 17:04
 * Des:
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        btn_login.setOnClickListener(this)
        code_view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                login()
            }
            R.id.code_view -> {
                code_view.updateCode()
            }
            else -> {
            }
        }
    }

    private fun login() {
        val mUserName = et_username.text.toString()
        val mPassword = et_password.text.toString()
        val mCode = code_view.text.toString()
        val user = User(mUserName, mPassword, mCode)
        if (verify(user)) {
            CacheUtils.save(usernameKey, mUserName)
            CacheUtils.save(passwordKey, mPassword)
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    private fun verify(user: User): Boolean {
        if (!user.username.isNullOrEmpty() && user.username!!.length < 4) {
            Utils.toast("用户名不合法")
            return false
        }
        if (!user.password.isNullOrEmpty() && user.password!!.length < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }


}