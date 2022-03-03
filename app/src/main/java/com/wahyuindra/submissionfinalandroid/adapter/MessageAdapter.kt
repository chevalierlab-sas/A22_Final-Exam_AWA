package com.wahyuindra.submissionfinalandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahyuindra.submissionfinalandroid.databinding.ItemMessageBinding
import com.wahyuindra.submissionfinalandroid.model.Aslab

class MessageAdapter(var items: ArrayList<Aslab>, var handler: (Aslab) -> Unit) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder) {
        bind(items[position])
        binding.root.setOnClickListener {
            handler(items[position])
        }
    }

    override fun getItemCount() = items.size

    class ViewHolder(var binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Aslab) = with(binding) {
            Glide.with(this.root)
                .load(item.image)
                .into(ivAslab)

            tvAslabName.text = item.name
            tvAslabMessage.text = item.message
        }
    }
}