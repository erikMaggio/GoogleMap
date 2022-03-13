package com.example.goooglemaps.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.goooglemaps.R
import com.example.goooglemaps.databinding.ItemListBinding
import com.example.goooglemaps.model.date.Shop

class ShopAdapter(private val shopList: List<Shop>) : RecyclerView.Adapter<ShopHolder>() {

    private lateinit var listener: OnClickListener

    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener2: OnClickListener) {
        listener = listener2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ShopHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ShopHolder, position: Int) {
        holder.render(shopList[position])
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}

class ShopHolder(view: View, listener: ShopAdapter.OnClickListener) :
    RecyclerView.ViewHolder(view) {

    private var binding = ItemListBinding.bind(view)

    fun render(shopList: Shop) {
        binding.name.text = shopList.name
    }

    init {
        view.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}