package com.raihan.foodstar.presentation.cart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.raihan.foodstar.R
import com.raihan.foodstar.data.datasource.cart.CartDataSource
import com.raihan.foodstar.data.datasource.cart.CartDatabaseDataSource
import com.raihan.foodstar.data.model.Cart
import com.raihan.foodstar.data.repository.CartRepository
import com.raihan.foodstar.data.repository.CartRepositoryImpl
import com.raihan.foodstar.data.source.local.database.AppDatabase
import com.raihan.foodstar.databinding.FragmentCartBinding
import com.raihan.foodstar.presentation.checkout.CheckoutActivity
import com.raihan.foodstar.presentation.common.adapter.CartListAdapter
import com.raihan.foodstar.presentation.common.adapter.CartListener
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.hideKeyboard
import com.raihan.foodstar.utils.proceedWhen
import com.raihan.foodstar.utils.toIndonesianFormat


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    private var isCheckoutButtonEnabled: Boolean = false

    private val viewModel: CartViewModel by viewModels {
        val db = AppDatabase.getInstance(requireContext())
        val ds: CartDataSource = CartDatabaseDataSource(db.cartDao())
        val rp: CartRepository = CartRepositoryImpl(ds)
        GenericViewModelFactory.create(CartViewModel(rp))
    }

    private val adapter: CartListAdapter by lazy {
        CartListAdapter(object : CartListener {
            override fun onPlusTotalItemCartClicked(cart: Cart) {
                viewModel.increaseCart(cart)
            }

            override fun onMinusTotalItemCartClicked(cart: Cart) {
                viewModel.decreaseCart(cart)
            }

            override fun onRemoveCartClicked(cart: Cart) {
                viewModel.removeCarts(cart)
            }

            override fun onUserDoneEditingNotes(cart: Cart) {
                viewModel.setCartNotes(cart)
                hideKeyboard()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        observeData()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btnCheckoutMenu.setOnClickListener {
            startActivity(Intent(requireContext(), CheckoutActivity::class.java))

        }
    }

    private fun updateCheckoutButtonState() {
        binding.btnCheckoutMenu.isEnabled = isCheckoutButtonEnabled
    }


    private fun observeData() {
        viewModel.getAllCarts().observe(viewLifecycleOwner) { result ->
            result.proceedWhen(
                doOnLoading = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = true
                    binding.layoutState.tvError.isVisible = false
                    binding.rvCart.isVisible = false
                    isCheckoutButtonEnabled = false
                    updateCheckoutButtonState()
                    binding.btnCheckoutMenu.visibility = View.GONE
                },
                doOnSuccess = {
                    binding.layoutState.root.isVisible = false
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = false
                    binding.rvCart.isVisible = true
                    isCheckoutButtonEnabled = true
                    updateCheckoutButtonState()
                    result.payload?.let { (carts, totalPrice) ->
                        //set list cart data
                        adapter.submitData(carts)
                        binding.tvTotalPriceValue.text = totalPrice.toIndonesianFormat()
                    }
                    binding.btnCheckoutMenu.visibility = View.VISIBLE
                },
                doOnError = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = true
                    binding.layoutState.tvError.text = result.exception?.message.orEmpty()
                    binding.rvCart.isVisible = false
                    isCheckoutButtonEnabled = false
                    updateCheckoutButtonState()
                },
                doOnEmpty = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = true
                    binding.layoutState.tvError.text = getString(R.string.text_cart_is_empty)
                    binding.rvCart.isVisible = false
                    isCheckoutButtonEnabled = false
                    updateCheckoutButtonState()
                    result.payload?.let { (carts, totalPrice) ->
                        binding.tvTotalPriceValue.text = totalPrice.toIndonesianFormat()
                    }
                    binding.btnCheckoutMenu.visibility = View.GONE
                }
            )
        }
    }

    private fun setupList() {
        binding.rvCart.adapter = this@CartFragment.adapter
    }
}