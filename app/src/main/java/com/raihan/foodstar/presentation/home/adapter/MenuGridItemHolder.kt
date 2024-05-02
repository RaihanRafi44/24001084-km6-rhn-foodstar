package com.raihan.foodstar.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.raihan.foodstar.R
import com.raihan.foodstar.base.ViewHolderBinder
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.ItemMenuBinding
import com.raihan.foodstar.databinding.ItemMenuGridBinding
import com.raihan.foodstar.utils.toIndonesianFormat

class MenuGridItemHolder(
    private val binding: ItemMenuGridBinding,
    private val listener: (Menu) -> Unit,
) : ViewHolder(binding.root), ViewHolderBinder<Menu> {
    override fun bind(item: Menu) {
        item.let {
            binding.ivCatalogImages.load(it.imgUrl) {
                crossfade(true)
                error(R.mipmap.ic_launcher_round)
            }
            binding.tvCatalogName.text = it.name
            binding.tvCatalogPrice.text = it.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}

class MenuListItemHolder(
    private val binding: ItemMenuBinding,
    private val listener: (Menu) -> Unit,
) : ViewHolder(binding.root), ViewHolderBinder<Menu> {
    override fun bind(item: Menu) {
        item.let {
            binding.ivCatalogImages.load(it.imgUrl) {
                crossfade(true)
                error(R.mipmap.ic_launcher_round)
            }
            binding.tvCatalogName.text = it.name
            binding.tvCatalogPrice.text = it.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}
