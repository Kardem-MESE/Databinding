package com.example.demo

import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class ViewModel:ViewModel() {
    //var sonuc = MutableLiveData<String>()
    var sekil = MutableLiveData<List<Sekiller>>()
    var sekillerList = arrayListOf<Sekiller>()

   /* init {
        sonuc = MutableLiveData<String>("0")
    }

    */
    /*
    fun dortgenalanbul(enteredLength:String,enteredHeight:String){
        val length = enteredLength.toInt()
        val height = enteredHeight.toInt()
        val squareArea = length * height
        sonuc.value = squareArea.toString()
    }
    fun ucgenalanbul(enteredLength:String,enteredHeight:String){
        val length = enteredLength.toInt()
        val height = enteredHeight.toInt()
        val triangleArea = length * height / 2
        sonuc.value = triangleArea.toString()
    }

     */
    fun refreshData(){
        val s1 = Sekiller(1,"Square")
        val s2 = Sekiller(2,"Rectangle")
        val s3 = Sekiller(3,"Triangle")
        sekillerList = arrayListOf<Sekiller>(s1,s2,s3)
        sekil.value = sekillerList

    }

    fun addsekil(sekiller: Sekiller){
        sekillerList.add(sekiller)
        sekil.value = sekillerList
    }
}








