package com.tutkuozbakir.stocktracking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tutkuozbakir.stocktracking.databinding.ItemRowBinding
import com.tutkuozbakir.stocktracking.model.StockItem
import com.tutkuozbakir.stocktracking.viewmodel.ItemViewModel

class ItemAdapter(var itemList: List<StockItem>, private val itemViewModel: ItemViewModel): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.tvItem.text = "${itemList.get(position).item_name} \n${itemList.get(position).item_count}"

        holder.binding.ibDelete.setOnClickListener{
            itemViewModel.delete(itemList[position])
        }

        holder.binding.ibPlus.setOnClickListener {
            itemList[position].item_count += 1
            itemViewModel.insert(itemList[position])
        }

        holder.binding.ibMinus.setOnClickListener {
            if(itemList[position].item_count > 0) {
                itemList[position].item_count -= 1
                itemViewModel.insert(itemList[position])
            }

        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


