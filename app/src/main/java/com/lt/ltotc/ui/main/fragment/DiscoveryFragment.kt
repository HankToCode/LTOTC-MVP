package com.lt.ltotc.ui.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.lt.ltotc.R
import com.lt.basics.base.BaseFragment
import com.lt.basics.base.BaseFragmentAdapter
import com.lt.basics.utils.StatusBarUtil
import com.lt.ltotc.view.TabLayoutHelper
import kotlinx.android.synthetic.main.fragment_hot.*

/**
 * Created by HankGreen on 2017/12/7.
 * desc: 发现(和热门首页同样的布局）
 */
class DiscoveryFragment : BaseFragment() {

    private val tabList = ArrayList<String>()

    private val fragments = ArrayList<Fragment>()

    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): DiscoveryFragment {
            val fragment = DiscoveryFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_hot

    override fun initView() {

        //状态栏透明和间距处理
        activity?.let { StatusBarUtil.darkMode(it) }
        activity?.let { StatusBarUtil.setPaddingSmart(it, toolbar) }

        tv_header_title.text = mTitle

        tabList.add("关注")
        tabList.add("分类")
        fragments.add(FollowFragment.getInstance("关注"))
        fragments.add(CategoryFragment.getInstance("分类"))

        /**
         * getSupportFragmentManager() 替换为getChildFragmentManager()
         */
        mViewPager.adapter = BaseFragmentAdapter(childFragmentManager, fragments, tabList)
        mTabLayout.setupWithViewPager(mViewPager)
        TabLayoutHelper.setUpIndicatorWidth(mTabLayout)


    }

    override fun lazyLoad() {
    }
}