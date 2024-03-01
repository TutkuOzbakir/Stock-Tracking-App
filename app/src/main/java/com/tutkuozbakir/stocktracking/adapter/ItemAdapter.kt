package com.tutkuozbakir.stocktracking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tutkuozbakir.stocktracking.databinding.ItemRowBinding
import com.tutkuozbakir.stocktracking.model.Item

class ItemAdapter(private val itemList: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.tvItem.text = "${itemList.get(position).item_name}/n${itemList.get(position).item_count}"


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


