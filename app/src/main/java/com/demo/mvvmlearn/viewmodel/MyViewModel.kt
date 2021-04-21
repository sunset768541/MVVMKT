package com.demo.mvvmlearn.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        Log.i("MyViewModel的相关","Activity被杀死后也会被销毁！");
    }
}