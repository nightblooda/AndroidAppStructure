package com.brainonet.brainonet.ui.intro

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.brainonet.brainonet.R
import com.brainonet.brainonet.ui.auth.AuthActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity: AppCompatActivity(){
    var position: Int = 0
    var btnAnim: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Full screen for activity

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        //check for the first time

        if(visitedBefore()){
            intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_intro)

        getSupportActionBar()?.hide()

        val btnNext = findViewById<Button>(R.id.btn_next)
        val btnGetStarted = findViewById<Button>(R.id.btn_get_started)
        val tabIndicator =  findViewById<TabLayout>(R.id.tab_indicator)
        btnAnim = AnimationUtils.loadAnimation(this,
            R.anim.button_animation
        )
        val tvSkip = findViewById<TextView>(R.id.tv_skip)

        val mList = ArrayList<ScreenItem>()
        mList.add(
            ScreenItem(
                "Get Your Community",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit ip",
                R.drawable.community
            )
        )
        mList.add(
            ScreenItem(
                "Fake news Detection",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit ip",
                R.drawable.start
            )
        )
        mList.add(
            ScreenItem(
                "Social Media Dashboard",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit ip",
                R.drawable.start
            )
        )

        //setup viewpager
        val screenPager = findViewById<ViewPager>(R.id.screen_viewpager)
        val introViewPagerAdapter =
            IntroViewPagerAdapter(this, mList)
        screenPager.adapter = introViewPagerAdapter

        //tab layout with viewpager

        tabIndicator.setupWithViewPager(screenPager)

        btnNext.setOnClickListener{

            position = screenPager.currentItem
            if(position < mList.size){
                position++
                screenPager.currentItem = position
            }

            if(position == mList.size-1){
                loadLastScreen()
            }

        }

        tabIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.position == mList.size -1){
                    loadLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        btnGetStarted.setOnClickListener{

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            savePrefsData()
            finish()
        }

        tvSkip.setOnClickListener{
            screenPager.setCurrentItem(mList.size)
        }



    }

    fun visitedBefore(): Boolean {
        val pref: SharedPreferences = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE);
        val isIntroActivityOpenedBefore: Boolean = pref.getBoolean("isIntroOpened", false)
        return isIntroActivityOpenedBefore
    }

    fun savePrefsData(){
        val pref: SharedPreferences = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE);
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putBoolean("isIntroOpened", true)
        editor.commit()
    }

    fun loadLastScreen(){
        btn_next.visibility = View.INVISIBLE
        btn_get_started.visibility = View.VISIBLE
        tv_skip.visibility = View.INVISIBLE
        tab_indicator.visibility = View.INVISIBLE
        btn_get_started.animation = btnAnim
    }
}