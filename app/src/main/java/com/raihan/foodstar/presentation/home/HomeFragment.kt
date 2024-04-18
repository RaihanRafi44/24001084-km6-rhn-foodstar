package com.raihan.foodstar.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.raihan.foodstar.R
import com.raihan.foodstar.data.datasource.category.CategoryApiDataSource
import com.raihan.foodstar.data.datasource.menu.MenuApiDataSource
import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.repository.CategoryRepository
import com.raihan.foodstar.data.repository.CategoryRepositoryImpl
import com.raihan.foodstar.data.repository.MenuRepository
import com.raihan.foodstar.data.repository.MenuRepositoryImpl
import com.raihan.foodstar.data.source.local.pref.UserPreferenceImpl
import com.raihan.foodstar.data.source.network.services.FoodStarApiService
import com.raihan.foodstar.databinding.FragmentHomeBinding
import com.raihan.foodstar.presentation.detailmenu.DetailMenuActivity
import com.raihan.foodstar.presentation.home.adapter.CategoryAdapter
import com.raihan.foodstar.presentation.home.adapter.MenuAdapter
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.proceedWhen

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels {
        val service = FoodStarApiService.invoke()
        val userPreference = UserPreferenceImpl(requireContext())
        val menuDataSource = MenuApiDataSource(service)
        val menuRepository: MenuRepository = MenuRepositoryImpl(menuDataSource)
        val categoryDataSource = CategoryApiDataSource(service)
        val categoryRepository: CategoryRepository = CategoryRepositoryImpl(categoryDataSource)
        GenericViewModelFactory.create(
            HomeViewModel(
                categoryRepository,
                menuRepository,
                userPreference))
    }
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter {
            getMenuData(it.name)
        }
    }

    private val menuAdapter: MenuAdapter by lazy {
        MenuAdapter(viewModel.getListMode()) {
            navigateToDetail(it)
        }
    }

    private fun getMenuData(name: String) {
        viewModel.getMenu(name).observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    it.payload?.let { data ->
                        bindMenuList(data)
                    }
                }
            )
        }
    }

    private fun setupMenu() {
        binding.rvCatalog.apply {
            adapter = menuAdapter
        }
    }

    private fun getCategoryData() {
        viewModel.getCategory().observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    it.payload?.let { data -> bindCategory(data) }
                }
            )
        }
    }

    private fun bindCategory(data: List<Category>) {
        categoryAdapter.submitData(data)
    }
    private fun setupCategory() {
        binding.rvCategory.apply {
            adapter = categoryAdapter
        }
    }

    private fun observeGridMode() {
        viewModel.isUsingGridMode.observe(viewLifecycleOwner) { isUsingGridMode ->
            changeBtnIcon(isUsingGridMode)
            changeLayout(isUsingGridMode)
        }
    }

    private fun changeLayout(usingGridMode: Boolean) {
        val listMode = if (usingGridMode) MenuAdapter.MODE_GRID else MenuAdapter.MODE_LIST
        menuAdapter.updateListMode(listMode)
        setupMenu()
        binding.rvCatalog.apply {
            layoutManager = GridLayoutManager(requireContext(), if (usingGridMode) 2 else 1)
        }
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            viewModel.changeListMode()
        }
    }


    private fun changeBtnIcon(isUsingGridMode: Boolean) {
        binding.btnChangeListMode.setIconResource(if (isUsingGridMode) R.drawable.ic_grid_black else R.drawable.ic_list_black)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategory()
        setupMenu()
        observeGridMode()
        getCategoryData()
        getMenuData(null.toString())
        setClickAction()
    }

    private fun bindCategoryList(data: List<Category>) {
        binding.rvCategory.apply {
            adapter = this@HomeFragment.categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun bindMenuList(data : List<Menu>) {
        menuAdapter.submitData(data)
    }

    private fun navigateToDetail(item: Menu) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(DetailMenuActivity.EXTRA_MENU, item))
        navController.navigate(R.id.action_menu_tab_home_to_detailMenuActivity, bundle)
    }
}