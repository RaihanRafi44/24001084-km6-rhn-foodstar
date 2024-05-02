package com.raihan.foodstar.presentation.detailmenu

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.raihan.foodstar.R
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.ActivityDetailMenuBinding
import com.raihan.foodstar.utils.proceedWhen
import com.raihan.foodstar.utils.toIndonesianFormat
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailMenuActivity : AppCompatActivity() {
    private val binding: ActivityDetailMenuBinding by lazy {
        ActivityDetailMenuBinding.inflate(layoutInflater)
    }
    private val detailMenuViewModel: DetailMenuViewModel by viewModel {
        parametersOf(intent.extras)
    }

    private var location = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindMenu(detailMenuViewModel.menu)
        setClickListener()
        observeData()
    }

    private fun setClickListener() {
        binding.layoutDetail.btnBackHome.setOnClickListener {
            finish()
        }
        binding.icMinus.setOnClickListener {
            detailMenuViewModel.minus()
        }
        binding.icAdd.setOnClickListener {
            detailMenuViewModel.add()
        }
        binding.layoutDetail.tvAddress.setOnClickListener {
            navigateToGoogleMaps()
        }
        binding.btnAddToCart.setOnClickListener {
            addMenuToCart()
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
        detailMenuViewModel.priceLiveData.observe(this) {
            binding.btnAddToCart.isEnabled = it != 0.0
            binding.tvTotalPrice.text = it.toIndonesianFormat()
        }
        detailMenuViewModel.menuCountLiveData.observe(this) {
            binding.tvQuantityText.text = it.toString()
        }
    }

    private fun addMenuToCart() {
        detailMenuViewModel.addToCart().observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    Toast.makeText(
                        this,
                        getString(R.string.text_add_to_cart_success),
                        Toast.LENGTH_SHORT,
                    ).show()
                    finish()
                },
                doOnError = {
                    Toast.makeText(this, getString(R.string.add_to_cart_failed), Toast.LENGTH_SHORT)
                        .show()
                },
                doOnLoading = {
                    Toast.makeText(this, getString(R.string.loading), Toast.LENGTH_SHORT).show()
                },
            )
        }
    }

    private fun navigateToGoogleMaps() {
        val mapUrl = Uri.parse(location)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUrl)
        startActivity(mapIntent)
    }

    companion object {
        const val EXTRA_MENU = "EXTRA_MENU"

        fun startActivity(
            context: Context,
            menu: Menu,
        ) {
            val intent = Intent(context, DetailMenuActivity::class.java)
            intent.putExtra(EXTRA_MENU, menu)
            context.startActivity(intent)
        }
    }
}
