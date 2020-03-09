package com.brainonet.brainonet.ui.intro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.brainonet.brainonet.R

class IntroViewPagerAdapter: PagerAdapter{

    var mContext: Context
    var mListScreen: List<ScreenItem>

    constructor(mContext: Context, mListScreen: List<ScreenItem>) {
        this.mContext = mContext
        this.mListScreen = mListScreen
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen: View = inflater.inflate(R.layout.layout_screen, null)

        val imgSlide: ImageView = layoutScreen.findViewById(R.id.intro_img)
        val title: TextView = layoutScreen.findViewById(R.id.intro_title)
        val description = layoutScreen.findViewById<TextView>(R.id.intro_description)

        title.text = mListScreen.get(position).Title
        description.text = mListScreen.get(position).Description
        mListScreen.get(position).ScreenImg?.let { imgSlide.setImageResource(it) }

        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }



    override fun getCount(): Int {
        return mListScreen.size
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)

    }
}