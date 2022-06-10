package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sekillerList:ArrayList<Sekiller>
    private lateinit var adapter:RVAdapter

    lateinit var inputtext :EditText
    lateinit var action_button: Button

    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_main)

        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)

        val s1 = Sekiller(1,"Square")
        val s2 = Sekiller(2,"Rectangle")
        val s3 = Sekiller(3,"Triangle")

        sekillerList = ArrayList<Sekiller>()
        sekillerList.add(s1)
        sekillerList.add(s2)
        sekillerList.add(s3)

        adapter = RVAdapter(this, sekillerList)
        rv.adapter = adapter

        inputtext = tasarim.Textwatcher
        action_button = tasarim.button3

        inputtext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                action_button.isEnabled = !inputtext.text.isEmpty()

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })



        tasarim.textViewSonuc.text = "0"

        tasarim.buttonSquare.setOnClickListener {
            val enteredLength = tasarim.editTextSideLength.text.toString()
            val enteredHeight = tasarim.editTextHeight.text.toString()

            val length = enteredLength.toInt()
            val height = enteredHeight.toInt()

            val squareArea = length * height
            

            tasarim.textViewSonuc.text = squareArea.toString()
        }

        tasarim.buttonTriangel.setOnClickListener {
            val enteredLength = tasarim.editTextSideLength.text.toString()
            val enteredHeight = tasarim.editTextHeight.text.toString()

            val length = enteredLength.toInt()
            val height = enteredHeight.toInt()

            val triangleArea = length * height / 2

            tasarim.textViewSonuc.text = triangleArea.toString()
        }
    }
}