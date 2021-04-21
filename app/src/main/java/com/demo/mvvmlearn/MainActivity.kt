package com.demo.mvvmlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.demo.mvvmlearn.databinding.ActivityMainBinding
import com.demo.mvvmlearn.model.User
import com.demo.mvvmlearn.util.LogUtil
import com.demo.mvvmlearn.viewmodel.MyViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
class MainActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding  = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
//        binding.textStr = "1000"
//        val sbo = ObservableField("我是第一份")
//        binding.user = User(sbo)
//        val uiScope = CoroutineScope(Dispatchers.Main)
//        uiScope.launch {
//            (1..10).asFlow() // 一个请求流
//                    .map { request -> performRequest(request) }
//                    .collect { response ->sbo.set(response)  }
//        }
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        Log.i("MyViewModel的相关", "onStart ==> " + myViewModel.hashCode());
    }

    override fun onClick(v: View?) {
        Log.d("我","点击了View")
    }
    suspend fun performRequest(request: Int): String {
        delay(1000) // 模仿长时间运行的异步工作
        return "response $request"
    }

    override fun onStart() {
        super.onStart()
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        Log.i("MyViewModel的相关", "onStart ==> " + myViewModel.hashCode())
    }
    override fun onResume() {
        super.onResume()
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        Log.i("MyViewModel的相关", "onResume ==> " + myViewModel.hashCode())
    }

    override fun onPause() {
        super.onPause()
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        Log.i("MyViewModel的相关", "onPause ==> " + myViewModel.hashCode())
    }

    override fun onStop() {
        super.onStop()
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        Log.i("MyViewModel的相关", "onStop ==> " + myViewModel.hashCode())
    }

    override fun onDestroy() {
        super.onDestroy()
        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        Log.i("MyViewModel的相关", "onDestroy ==> " + myViewModel.hashCode())
    }
}
