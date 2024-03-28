package com.raihan.foodstar.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.ItemMenuBinding
import com.raihan.foodstar.databinding.ItemMenuGridBinding
import com.raihan.foodstar.utils.toIndonesianFormat

class MenuAdapter(private val itemClick: (Menu) -> Unit):
    RecyclerView.Adapter<MenuAdapter.ItemMenuViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<Menu>() {
                override fun areItemsTheSame(
                    oldItem: Menu,
                    newItem: Menu
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Menu,
                    newItem: Menu
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    fun submitData(data: List<Menu>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMenuViewHolder {
        val binding = ItemMenuGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemMenuViewHolder(binding, itemClick)

    }

    override fun onBindViewHolder(holder: ItemMenuViewHolder, position: Int) {
        holder.bindView(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    class ItemMenuViewHolder(
        private val binding: ItemMenuGridBinding,
        val itemClick: (Menu) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Menu) {
            with(item) {
                binding.ivCatalogImages.load(item.imgUrl) {
                    crossfade(true)
                }
                binding.tvCatalogName.text = item.name
                binding.tvCatalogPrice.text = item.price.toIndonesianFormat()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
