package com.elgrilloparlante.tarotmobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.elgrilloparlante.tarotmobile.R
import com.elgrilloparlante.tarotmobile.models.Card

class CardsAdapter(private val cardList: List<Card>) :
    RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val frontImageView: ImageView = itemView.findViewById(R.id.frontImageView)
        val backImageView: ImageView = itemView.findViewById(R.id.backImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cardList[position]
        if (card.isFaceUp) {
            holder.frontImageView.visibility = View.VISIBLE
            holder.backImageView.visibility = View.INVISIBLE
        } else {
            holder.frontImageView.visibility = View.INVISIBLE
            holder.backImageView.visibility = View.VISIBLE
        }

        // Mostrar el frente correspondiente
        holder.frontImageView.setImageResource(card.cardImage)

        holder.itemView.setOnClickListener {
            card.isFaceUp = !card.isFaceUp
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}
