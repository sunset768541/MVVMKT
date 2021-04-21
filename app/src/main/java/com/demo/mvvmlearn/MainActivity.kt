package com.demo.mvvmlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.demo.mvvmlearn.databinding.ActivityMainBinding
import com.demo.mvvmlearn.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
class MainActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding  = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.textStr = "1000"
        val sbo = ObservableField("我是第一份")
        binding.user = User(sbo)
        val uiScope = CoroutineScope(Dispatchers.Main)
        uiScope.launch {
            (1..10).asFlow() // 一个请求流
                    .map { request -> performRequest(request) }
                    .collect { response ->sbo.set(response)  }
        }

    }

    override fun onClick(v: View?) {
        Log.d("我","点击了View")
    }
    suspend fun performRequest(request: Int): String {
        delay(1000) // 模仿长时间运行的异步工作
        return "response $request"
    }


}