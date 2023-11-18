package com.example.checkpoint3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemListAdapter(
    private val itemList: MutableList<Item>,
    private val onDeleteItemClickListener: OnDeleteItemClickListener,
    private val onChangeItemClickListener: OnChangeItemClickListener
) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    interface OnDeleteItemClickListener {
        fun onDeleteItemClick(position: Int)
    }

    interface OnChangeItemClickListener {
        fun onChangeItemClick(position: Int)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.item_view)
        val itemStatus: TextView = itemView.findViewById(R.id.status_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemName.text = currentItem.amount + " x " + currentItem.name
        holder.itemView.findViewById<ImageView>(R.id.delete_button).setOnClickListener {
            onDeleteButtonClick(position)
        }
        holder.itemView.findViewById<TextView>(R.id.status_view).setOnClickListener {
            onChangeButtonClick(position)
        }

        if (currentItem.status) {
            holder.itemStatus.text = "Pronto"
        } else {
            holder.itemStatus.text = "Pendente"
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    private fun onDeleteButtonClick(position: Int) {
        onDeleteItemClickListener.onDeleteItemClick(position)
    }

    private fun onChangeButtonClick(position: Int) {
        onChangeItemClickListener.onChangeItemClick(position)
    }
}