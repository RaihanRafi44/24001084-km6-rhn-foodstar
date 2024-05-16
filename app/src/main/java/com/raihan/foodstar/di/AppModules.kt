package com.raihan.foodstar.di

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.raihan.foodstar.data.datasource.auth.AuthDataSource
import com.raihan.foodstar.data.datasource.auth.FirebaseAuthDataSource
import com.raihan.foodstar.data.datasource.cart.CartDataSource
import com.raihan.foodstar.data.datasource.cart.CartDatabaseDataSource
import com.raihan.foodstar.data.datasource.category.CategoryApiDataSource
import com.raihan.foodstar.data.datasource.category.CategoryDataSource
import com.raihan.foodstar.data.datasource.menu.MenuApiDataSource
import com.raihan.foodstar.data.datasource.menu.MenuDataSource
import com.raihan.foodstar.data.datasource.pref.UserPreference
import com.raihan.foodstar.data.datasource.pref.UserPreferenceImpl
import com.raihan.foodstar.data.repository.CartRepository
import com.raihan.foodstar.data.repository.CartRepositoryImpl
import com.raihan.foodstar.data.repository.CategoryRepository
import com.raihan.foodstar.data.repository.CategoryRepositoryImpl
import com.raihan.foodstar.data.repository.MenuRepository
import com.raihan.foodstar.data.repository.MenuRepositoryImpl
import com.raihan.foodstar.data.repository.UserPreferenceRepository
import com.raihan.foodstar.data.repository.UserPreferenceRepositoryImpl
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.data.repository.UserRepositoryImpl
import com.raihan.foodstar.data.source.firebase.FirebaseService
import com.raihan.foodstar.data.source.firebase.FirebaseServiceImpl
import com.raihan.foodstar.data.source.local.database.AppDatabase
import com.raihan.foodstar.data.source.local.database.dao.CartDao
import com.raihan.foodstar.data.source.network.services.FoodStarApiService
import com.raihan.foodstar.presentation.cart.CartViewModel
import com.raihan.foodstar.presentation.checkout.CheckoutViewModel
import com.raihan.foodstar.presentation.detailmenu.DetailMenuViewModel
import com.raihan.foodstar.presentation.home.HomeViewModel
import com.raihan.foodstar.presentation.login.LoginViewModel
import com.raihan.foodstar.presentation.main.MainViewModel
import com.raihan.foodstar.presentation.profile.ProfileViewModel
import com.raihan.foodstar.presentation.register.RegisterViewModel
import com.raihan.foodstar.presentation.splashscreen.SplashViewModel
import com.raihan.foodstar.utils.SharedPreferenceUtils
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModules {
    private val networkModule =
        module {
            single<FoodStarApiService> { FoodStarApiService.invoke() }
        }

    // todo : add firebase module
    private val firebaseModule =
        module {
            single<FirebaseAuth> { FirebaseAuth.getInstance() }
            single<FirebaseService> { FirebaseServiceImpl(get()) }
        }

    private val localModule =
        module {
            single<AppDatabase> { AppDatabase.createInstance(androidContext()) }
            single<CartDao> { get<AppDatabase>().cartDao() }
            single<SharedPreferences> {
                SharedPreferenceUtils.createPreference(
                    androidContext(),
                    UserPreferenceImpl.PREF_NAME,
                )
            }
            single<UserPreference> { UserPreferenceImpl(get()) }
        }
    private val dataSource =
        module {
            single<CartDataSource> { CartDatabaseDataSource(get()) }
            single<CategoryDataSource> { CategoryApiDataSource(get()) }
            single<MenuDataSource> { MenuApiDataSource(get()) }
            // single<UserDataSource> { UserDataSourceImpl() }
            single<AuthDataSource> { FirebaseAuthDataSource(get()) }
        }

    private val repository =
        module {
            single<CartRepository> { CartRepositoryImpl(get()) }
            single<CategoryRepository> { CategoryRepositoryImpl(get()) }
            single<MenuRepository> { MenuRepositoryImpl(get()) }
            single<UserRepository> { UserRepositoryImpl(get()) }
            single<UserPreferenceRepository> { UserPreferenceRepositoryImpl(get()) }
        }

    private val viewModelModule =
        module {
            viewModelOf(::SplashViewModel)
            viewModelOf(::HomeViewModel)
            viewModelOf(::CartViewModel)
            viewModelOf(::CheckoutViewModel)
            viewModel { params ->
                // assisted injection
                DetailMenuViewModel(
                    extras = params.get(),
                    cartRepository = get(),
                )
            }
            viewModelOf(::LoginViewModel)
            viewModelOf(::MainViewModel)
            viewModelOf(::ProfileViewModel)
            viewModelOf(::RegisterViewModel)
        }

    val modules =
        listOf<Module>(
            networkModule,
            localModule,
            dataSource,
            repository,
            viewModelModule,
            firebaseModule,
        )
}
