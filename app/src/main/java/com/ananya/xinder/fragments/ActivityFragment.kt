package com.ananya.xinder.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.ananya.xinder.adapters.ViewPagerAdapter
import com.thecode.tinderclone.R
import kotlinx.android.synthetic.main.fragment_activity.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ActivityFragment : Fragment(), View.OnClickListener, OnPageChangeListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onResume() {
        super.onResume()
        val fragList =
                ArrayList<Fragment>()
        fragList.add(ChatFragment())
        fragList.add(FeedFragment())
        val pagerAdapter =
                ViewPagerAdapter(fragList, activity!!.supportFragmentManager)
        view_pager_frag.setAdapter(pagerAdapter)
        view_pager_frag.addOnPageChangeListener(this)
        layout_chat.setOnClickListener(this)
        layout_feed.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.layout_chat -> {
                view_pager_frag!!.currentItem = 0
                text_chat!!.setTextColor(resources.getColor(R.color.colorPrimary))
                text_feed!!.setTextColor(resources.getColor(R.color.light_gray))
            }
            R.id.layout_feed -> {
                view_pager_frag!!.currentItem = 1
                text_chat!!.setTextColor(resources.getColor(R.color.light_gray))
                text_feed!!.setTextColor(resources.getColor(R.color.colorPrimary))
            }
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                text_chat!!.setTextColor(resources.getColor(R.color.colorPrimary))
                text_feed!!.setTextColor(resources.getColor(R.color.light_gray))
            }
            1 -> {
                text_chat!!.setTextColor(resources.getColor(R.color.light_gray))
                text_feed!!.setTextColor(resources.getColor(R.color.colorPrimary))
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}
}