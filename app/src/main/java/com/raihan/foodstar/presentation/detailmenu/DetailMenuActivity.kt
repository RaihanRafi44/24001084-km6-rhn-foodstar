package com.raihan.foodstar.presentation.detailmenu

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.raihan.foodstar.R
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.ActivityDetailMenuBinding
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.toIndonesianFormat

/*
class DetailMenuActivity : AppCompatActivity() {

    private val binding : ActivityDetailMenuBinding by lazy {
        ActivityDetailMenuBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    companion object {
        const val EXTRA_MENU = "EXTRA_MENU"
        fun startActivity(context: Context, menu: Menu) {
            val intent = Intent(context, DetailMenuActivity::class.java)
            intent.putExtra(EXTRA_MENU, menu)
            context.startActivity(intent)
        }
    }

}*/

class DetailMenuActivity : AppCompatActivity() {
    private val binding: ActivityDetailMenuBinding by lazy {
        ActivityDetailMenuBinding.inflate(layoutInflater)
    }
    private val viewModel: DetailMenuViewModel by viewModels {
        GenericViewModelFactory.create(
            DetailMenuViewModel(intent?.extras)
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindMenu(viewModel.menu)
        setClickListener()
        observeData()
    }

    private fun setClickListener() {
        binding.layoutDetail.btnBackHome.setOnClickListener {
            finish()
        }
        binding.icMinus.setOnClickListener {
            viewModel.minus()
        }
        binding.icAdd.setOnClickListener {
            viewModel.add()
        }
    }

    private fun bindMenu(menu: Menu?) {
        menu?.let { item ->
            binding.layoutDetail.ivCatalogImages.load(item.imgUrl) {
                crossfade(true)
            }
            binding.layoutDetail.tvCatalogName.text = item.name
            binding.layoutDetail.tvFoodDesc.text = item.desc
            binding.layoutDetail.tvCatalogPrice.text = item.price.toIndonesianFormat()
        }
    }

    private fun observeData() {
        viewModel.priceLiveData.observe(this) {
            binding.tvTotalPrice.text = it.toIndonesianFormat()
        }
        viewModel.menuCountLiveData.observe(this) {
            binding.tvQuantityText.text = it.toString()
        }
    }

    companion object {
        const val EXTRA_MENU = "EXTRA_MENU"
        fun startActivity(context: Context, menu: Menu) {
            val intent = Intent(context, DetailMenuActivity::class.java)
            intent.putExtra(EXTRA_MENU, menu)
            context.startActivity(intent)
        }
    }
}
