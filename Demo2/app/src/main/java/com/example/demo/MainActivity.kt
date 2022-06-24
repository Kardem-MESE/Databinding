package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.databinding.ActivityMainBinding
import com.example.demo.databinding.CardTasarimiBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_tasarimi.*

class MainActivity : AppCompatActivity() {

    private val viewModel:ViewModel by viewModels()
    private lateinit var adapter:RVAdapter
    lateinit var inputtext :EditText
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setRecyclerview()
        setListeners()
        //resultcalculation()
        viewModel.refreshData()

    }
    /*private fun resultcalculation() {
        viewModel.sonuc.observe(this,{ s ->
            binding.textViewSonuc.text = s
        })
    }

     */
    private fun setListeners() {
        binding.button3.setOnClickListener {
            val s1 = Sekiller(4,"Elips")
            viewModel.addsekil(s1)
        }
        binding.Textwatcher.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        /*
        binding.buttonSquare.setOnClickListener {
            val enteredLength = binding.editTextSideLength.text.toString()
            val enteredHeight = binding.editTextHeight.text.toString()
            viewModel.dortgenalanbul(enteredLength,enteredHeight)
        }
        binding.buttonTriangel.setOnClickListener {
            val enteredLength = binding.editTextSideLength.text.toString()
            val enteredHeight = binding.editTextHeight.text.toString()
            viewModel.ucgenalanbul(enteredLength,enteredHeight)
        }

         */
    }


    private fun setRecyclerview() {
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=LinearLayoutManager(this)
        viewModel.sekil.observe(this,{s ->
            adapter = RVAdapter(this, s)
            binding.rv.adapter = adapter
        })
    }
}