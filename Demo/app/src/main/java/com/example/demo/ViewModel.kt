package com.example.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModel:ViewModel() {

    var sonuc = MutableLiveData<String>()

    init {
        sonuc = MutableLiveData<String>("0")
    }

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
    /*

    val sekil = MutableLiveData<List<Sekiller>>()

    fun refreshData(){
        val s1 = Sekiller(1,"Square")
        val s2 = Sekiller(2,"Rectangle")
        val s3 = Sekiller(3,"Triangle")



        val sekillerList = arrayListOf<Sekiller>(s1,s2,s3)
        sekillerList.add(s1)
        sekillerList.add(s2)
        sekillerList.add(s3)
        sekil.value = sekillerList
    }

     */


}