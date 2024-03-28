package com.raihan.foodstar.presentation.detailmenu

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.ActivityDetailMenuBinding
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.toIndonesianFormat


class DetailMenuActivity : AppCompatActivity() {
    private val binding: ActivityDetailMenuBinding by lazy {
        ActivityDetailMenuBinding.inflate(layoutInflater)
    }
    private val viewModel: DetailMenuViewModel by viewModels {
        GenericViewModelFactory.create(
            DetailMenuViewModel(intent?.extras)
        )
    }

    private var location = ""

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
        binding.layoutDetail.tvAddress.setOnClickListener {
            navigateToGoogleMaps()
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
            location = item.addressUrl
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

    private fun navigateToGoogleMaps() {

        val mapsURL = Uri.parse(location)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapsURL)
        startActivity(mapIntent)
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
