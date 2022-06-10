package com.example.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext:Context, private val SekillerListesi:List<Sekiller>)
    : RecyclerView.Adapter<RVAdapter.CardViewTasarimNesneTutucu>(){

    inner class CardViewTasarimNesneTutucu(view:View):RecyclerView.ViewHolder(view){
        var satirCardView:CardView
        var satirYazi:TextView
        var yildizResim:ImageView

        init {
            satirCardView=view.findViewById(R.id.satirCardView)
            satirYazi=view.findViewById(R.id.satirYazi)
            yildizResim=view.findViewById(R.id.yildizResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewTasarimNesneTutucu {

        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarimi,parent,false)

        return CardViewTasarimNesneTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewTasarimNesneTutucu, position: Int) {
        val sekil = SekillerListesi[position]
        holder.satirYazi.text = sekil.SekilAdi
        holder.satirCardView.setOnClickListener {
            Toast.makeText(mContext, "Seçtiğiniz Sekil : ${sekil.SekilAdi}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return SekillerListesi.size
    }
}