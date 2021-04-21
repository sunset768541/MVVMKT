package com.demo.mvvmlearn

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.demo.mvvmlearn.databinding.ActivityLivedataBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class LiveDataTestActivity : AppCompatActivity() {
    var binding: ActivityLivedataBinding?=null
    val liveData: MutableLiveData<String> = MutableLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLivedataBinding? = DataBindingUtil.setContentView(this, R.layout.activity_livedata)
        binding?.onlyLive = liveData.value
        liveData.observe(this, Observer {
            binding?.onlyLive = it
            Log.d("观察LiveData", "单独使用LiveData ==> $it")
        })
        val myflo = flow<String> {
            delay(10000)
            emit("1ss")
        }
        val uiScope = CoroutineScope(Dispatchers.Main)
        uiScope.launch {
            myflo.collect {
                liveData.value = it
            }
        }

    }

    override fun onStop() {
        super.onStop()
        liveData.postValue("单独使用LiveData")
    }
}