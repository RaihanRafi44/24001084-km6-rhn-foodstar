package com.raihan.foodstar.presentation.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.raihan.foodstar.data.datasource.auth.AuthDataSource
import com.raihan.foodstar.data.datasource.auth.FirebaseAuthDataSource
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.data.repository.UserRepositoryImpl
import com.raihan.foodstar.data.source.firebase.FirebaseService
import com.raihan.foodstar.data.source.firebase.FirebaseServiceImpl
import com.raihan.foodstar.databinding.ActivitySplashBinding
import com.raihan.foodstar.presentation.login.LoginActivity
import com.raihan.foodstar.presentation.main.MainActivity
import com.raihan.foodstar.utils.GenericViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {


    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    private val viewModel : SplashViewModel by viewModels {
        val s : FirebaseService = FirebaseServiceImpl()
        val ds : AuthDataSource = FirebaseAuthDataSource(s)
        val r : UserRepository = UserRepositoryImpl(ds)
        GenericViewModelFactory.create(SplashViewModel(r))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        checkIfUserLogin()
    }

    private fun checkIfUserLogin() {
        lifecycleScope.launch {
            delay(2000)
            //todo : checking user login
            if (viewModel.isUserLoggedIn()) {
                navigateToMain()
            } else {
                navigateToLogin()
            }
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })

    }

    private fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }
}