package com.wahyuindra.submissionfinalandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahyuindra.submissionfinalandroid.databinding.ItemHomeBinding
import com.wahyuindra.submissionfinalandroid.model.Aslab

class HomeAdapter(var items: ArrayList<Aslab>, var handler: (Aslab) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(
        ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = with(holder) {
        bind(items[position])
        this.binding.root.setOnClickListener { handler(items[position]) }
    }

    override fun getItemCount() = items.size

    class HomeViewHolder(var binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(aslab: Aslab) = with(binding) {
            Glide.with(this.root)
                .load(aslab.image)
                .into(ivAslab)
            tvAslabName.text = aslab.name
            tvAslabRole.text = aslab.role
        }
    }
}