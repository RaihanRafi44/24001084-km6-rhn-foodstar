package com.raihan.foodstar.presentation.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.raihan.foodstar.data.model.Cart
import com.raihan.foodstar.data.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository) : ViewModel() {


    fun getAllCarts() = cartRepository.getUserCartData().asLiveData(Dispatchers.IO)

    val cartList = cartRepository.getUserCartData().asLiveData(Dispatchers.IO)

    fun increaseCart(item: Cart){
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.increaseCart(item).collect()
        }
    }
    fun decreaseCart(item: Cart){
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.decreaseCart(item).collect()
        }
    }

    fun removeCarts(item: Cart){
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.deleteCart(item).collect()
        }
    }
    fun setCartNotes(item: Cart){
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.setCartNotes(item).collect{
                Log.d("Set Notes", "setCartNotes: $it")
            }
        }
    }

}