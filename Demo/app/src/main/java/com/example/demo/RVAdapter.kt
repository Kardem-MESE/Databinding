package com.example.demo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.RVAdapter.CardViewTasarimNesneTutucu
import com.example.demo.databinding.ActivityMainBinding
import com.example.demo.databinding.CardTasarimiBinding




class RVAdapter(private val mContext:Context, private val SekillerListesi:List<Sekiller>)
    : RecyclerView.Adapter<CardViewTasarimNesneTutucu>() {




    inner class CardViewTasarimNesneTutucu(view: CardTasarimiBinding) : RecyclerView.ViewHolder(view.root) {

        var satirCardView: CardView
        var satirYazi: TextView
        var yildizResim: ImageView

        init {


            satirCardView= view.satirCardView
            satirYazi = view.satirYazi
            yildizResim = view.yildizResim

        }
    }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CardViewTasarimNesneTutucu {


           // val tasarim =
               // LayoutInflater.from(mContext).inflate(R.layout.card_tasarimi, parent, false)
            val inflater = LayoutInflater.from(parent.context)
            val tasarim = DataBindingUtil.inflate<CardTasarimiBinding>(inflater,R.layout.card_tasarimi,parent,false)
            return CardViewTasarimNesneTutucu(tasarim)


        }


        override fun onBindViewHolder(holder: CardViewTasarimNesneTutucu, position: Int) {


            val sekil = SekillerListesi[position]
            holder.satirYazi.text = sekil.SekilAdi
            holder.satirCardView.setOnClickListener {
                Toast.makeText(mContext, "Seçtiğiniz Sekil : ${sekil.SekilAdi}", Toast.LENGTH_SHORT)
                    .show()
            }



        }

        override fun getItemCount(): Int {
            return SekillerListesi.size
        }
    }

