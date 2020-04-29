package com.ananya.xinder.activities

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thecode.tinderclone.R
import com.ananya.xinder.adapters.ViewPagerAdapter
import com.ananya.xinder.fragments.AccountFragment
import com.ananya.xinder.fragments.ActivityFragment
import com.ananya.xinder.fragments.MessagesFragment
import com.ananya.xinder.fragments.SwipeViewFragment
import java.util.*

class TinderCloneMainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var mContext: Context? = null
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        val bnv = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fragList =
                ArrayList<Fragment>()
        fragList.add(AccountFragment())
        fragList.add(SwipeViewFragment())
        fragList.add(ActivityFragment())
        fragList.add(MessagesFragment())
        val pagerAdapter = ViewPagerAdapter(fragList, supportFragmentManager)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 4
        bnv.setOnNavigationItemSelectedListener(this)
        changePage(1)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.account -> changePage(0)
            R.id.fire -> changePage(1)
            R.id.chat -> changePage(2)
        }
        return true
    }

     fun changePage(page:Int) {
        viewPager.currentItem = page
    }

    override fun onBackPressed() {
        changePage((viewPager.currentItem+1)%4)
    }
}