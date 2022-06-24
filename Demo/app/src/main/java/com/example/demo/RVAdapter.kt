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
    inner class CardViewTasarimNesneTutucu(binding: CardTasarimiBinding) : RecyclerView.ViewHolder(binding.root) {
        var satirCardView: CardView
        var satirYazi: TextView
        var yildizResim: ImageView

        init {
            satirCardView= binding.satirCardView
            satirYazi = binding.satirYazi
            yildizResim = binding.yildizResim
        }
    }
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CardViewTasarimNesneTutucu {
            val inflater = LayoutInflater.from(parent.context)
            val binding = DataBindingUtil.inflate<CardTasarimiBinding>(inflater,R.layout.card_tasarimi,parent,false)
            return CardViewTasarimNesneTutucu(binding)
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

