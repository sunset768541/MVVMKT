package com.demo.mvvmlearn.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

data class User (  var name: ObservableField<String>): BaseObservable() {

}