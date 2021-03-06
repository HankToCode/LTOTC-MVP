package com.lt.ltotc.ui.main.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import com.lt.basics.MyApplication
import com.lt.ltotc.R
import com.lt.basics.base.BaseActivity
import com.lt.basics.utils.AppUtils
import com.lt.basics.utils.StatusBarUtil
import kotlinx.android.synthetic.main.activity_about.*

/**
 * Created by HankGreen on 2017/12/6.
 * desc: 关于
 */
class AboutActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_about

    override fun initData() {
    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        StatusBarUtil.darkMode(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)

        tv_version_name.text ="v${AppUtils.getVerName(MyApplication.context)}"
        //返回
        toolbar.setNavigationOnClickListener { finish() }
        //访问 GitHub
        relayout_gitHub.setOnClickListener {
            val uri = Uri.parse("https://github.com/git-xuhao/KotlinMvp")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun start() {

    }
}
