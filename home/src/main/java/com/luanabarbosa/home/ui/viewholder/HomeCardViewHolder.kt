package com.luanabarbosa.home.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.circularreveal.CircularRevealGridLayout
import com.luanabarbosa.home.R

class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val cardName: TextView = itemView.findViewById(R.id.card_name)
    val cardImage: ImageView = itemView.findViewById(R.id.card_image)
    val cardsView: CircularRevealGridLayout = itemView.findViewById(R.id.cardsView)
}
