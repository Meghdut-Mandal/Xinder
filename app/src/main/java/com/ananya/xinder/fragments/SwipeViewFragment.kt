package com.ananya.xinder.fragments

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import com.thecode.tinderclone.R
import com.ananya.xinder.Utils
import com.ananya.xinder.entities.TinderCard
import kotlinx.android.synthetic.main.fragment_swipe_view.*

/**
 * A simple [Fragment] subclass.
 */
class SwipeViewFragment : Fragment() {
    private var rootLayout: View? = null
    private lateinit var fabBack: FloatingActionButton
    private lateinit var fabLike: FloatingActionButton
    private lateinit var fabSkip: FloatingActionButton
    private lateinit var fabSuperLike: FloatingActionButton
    private lateinit var fabBoost: FloatingActionButton
    private lateinit var mSwipeView: SwipePlaceHolderView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootLayout = inflater.inflate(R.layout.fragment_swipe_view, container, false)
        return rootLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSwipeView = view.findViewById(R.id.swipeView)
        fabBack = view.findViewById(R.id.fabBack)
        fabLike = view.findViewById(R.id.fabLike)
        fabSkip = view.findViewById(R.id.fabSkip)
        fabSuperLike = view.findViewById(R.id.fabSuperLike)
        fabBoost = view.findViewById(R.id.fabBoost)
        Handler().postDelayed({
            looking_view.visibility=View.INVISIBLE
            mSwipeView.visibility=View.VISIBLE
        },4*1000 )
        val bottomMargin = Utils.dpToPx(100)
        val windowSize =
                Utils.getDisplaySize(activity!!.windowManager)
        mSwipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
                .setDisplayViewCount(3)
                .setSwipeDecor(SwipeDecor()
                        .setViewWidth(windowSize.x)
                        .setViewHeight(windowSize.y - bottomMargin)
                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view))
        for (profile in Utils.loadProfiles(activity!!)!!) {
            mSwipeView.addView(TinderCard(context!!, profile, mSwipeView))
        }
        fabSkip.setOnClickListener { v: View? ->
            animateFab(fabSkip)
            mSwipeView.doSwipe(false)
        }
        fabLike.setOnClickListener { v: View? ->
            animateFab(fabLike)
            mSwipeView.doSwipe(true)
        }
        fabBoost.setOnClickListener { v: View? -> animateFab(fabBoost) }
        fabSuperLike.setOnClickListener { v: View? -> animateFab(fabSuperLike) }
        fabBack.setOnClickListener { v: View? -> animateFab(fabBack) }
    }

    private fun animateFab(fab: FloatingActionButton?) {
        fab!!.animate().scaleX(0.7f).setDuration(100).withEndAction { fab.animate().scaleX(1f).scaleY(1f) }
    }
}