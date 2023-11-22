package com.example.checkpoint3.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkpoint3.databinding.FragmentHomeBinding
import com.example.checkpoint3.databinding.ItemHospitalBinding

class HospitalAdapter(
    private val binding: FragmentHomeBinding,
    private val hospitalList: List<Hospital>
    ): RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    class HospitalViewHolder(binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val nome: TextView = binding.textView3
        val endereco: TextView = binding.textView2
        val distancia: TextView = binding.textView4

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemHospitalBinding.inflate(inflater, parent, false)
        return HospitalViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        val currentItem = hospitalList[position]

        holder.nome.text = currentItem.name
        holder.endereco.text = currentItem.address
        holder.distancia.text = currentItem.distance
    }
}


