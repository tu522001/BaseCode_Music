package com.example.music.ui.base

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by TruyenIT
 */


abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    private var _binding: T? = null
    protected val binding: T
        get() = _binding as T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
//        hideStatusBar()
        initViewModel()
        initView()
        addEvent()
        addObservers()
        initData()
    }

    abstract fun getViewBinding(): T

    open fun initViewModel() = Unit

    open fun initView() = Unit

    open fun addEvent() = Unit

    open fun addObservers() = Unit

    open fun initData() = Unit
//    private fun hideStatusBar() {
////        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
////        window.setFlags(
////            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
////        );
////
////        val decorView: View = window.decorView
////        val uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN
////        decorView.systemUiVisibility = uiOptions
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
////            window.decorView.windowInsetsController?.hide(
////                android.view.WindowInsets.Type.statusBars()
////            )
////        }
//        window.statusBarColor = ContextCompat.getColor(this, R.color.main_black)
//    }
}