package com.luanabarbosa.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.databinding.FragmentHomeCardItemBinding
import com.luanabarbosa.home.ui.viewholder.HomeCardViewHolder
import com.luanabarbosa.toolkit.extensions.load
import com.luanabarbosa.toolkit.extensions.setValueOrDefault

class HomeCardAdapter(
    private val cardsList: List<CoreModel>,
    private val listener: (CoreModel) -> Unit
) : RecyclerView.Adapter<HomeCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        val view = FragmentHomeCardItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        return HomeCardViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        with(cardsList[position]) {
            holder.cardImage.load(img)
            holder.cardName.setValueOrDefault(name, "Nome: não informado")
            holder.cardsView.setOnClickListener {
                listener(this)
            }
        }
    }

    override fun getItemCount(): Int = cardsList.size
}
