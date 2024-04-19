package com.raihan.foodstar.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.raihan.foodstar.R
import com.raihan.foodstar.data.datasource.auth.AuthDataSource
import com.raihan.foodstar.data.datasource.auth.FirebaseAuthDataSource
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.data.repository.UserRepositoryImpl
import com.raihan.foodstar.data.source.firebase.FirebaseService
import com.raihan.foodstar.data.source.firebase.FirebaseServiceImpl
import com.raihan.foodstar.databinding.ActivityMainBinding
import com.raihan.foodstar.presentation.login.LoginActivity
import com.raihan.foodstar.utils.GenericViewModelFactory

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels {
        val s: FirebaseService = FirebaseServiceImpl()
        val ds: AuthDataSource = FirebaseAuthDataSource(s)
        val r: UserRepository = UserRepositoryImpl(ds)
        GenericViewModelFactory.create(MainViewModel(r))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNav()
        //throw IllegalAccessException("Test Crash")
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.menu_tab_profile -> {
                    if(!viewModel.isLoggedIn()){
                        navigateToLogin()
                        controller.popBackStack(R.id.menu_tab_home, false)
                    }
                }
            }
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        })
    }
}