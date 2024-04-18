package com.raihan.foodstar.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.raihan.foodstar.base.ViewHolderBinder
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.ItemMenuBinding
import com.raihan.foodstar.databinding.ItemMenuGridBinding

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}

class MenuAdapter(
    private var listMode: Int,
    private val listener: (Menu) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var dataDiffer =
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (listMode == MODE_GRID) {
            MenuGridItemHolder(
                ItemMenuGridBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                listener
            )
        } else {
            MenuListItemHolder(
                ItemMenuBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                listener
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuGridItemHolder -> holder.bind(dataDiffer.currentList[position])
            is MenuListItemHolder -> holder.bind(dataDiffer.currentList[position])
        }
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size
    fun updateListMode(newListMode: Int) {
        listMode = newListMode
    }
}
