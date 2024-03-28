package com.raihan.foodstar.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.raihan.foodstar.data.datasource.category.DummyCategoryDataSource
import com.raihan.foodstar.data.datasource.menu.DummyMenuDataSource
import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.repository.CategoryRepository
import com.raihan.foodstar.data.repository.CategoryRepositoryImpl
import com.raihan.foodstar.data.repository.MenuRepository
import com.raihan.foodstar.data.repository.MenuRepositoryImpl
import com.raihan.foodstar.databinding.FragmentHomeBinding
import com.raihan.foodstar.presentation.detailmenu.DetailMenuActivity
import com.raihan.foodstar.presentation.home.adapter.CategoryAdapter
import com.raihan.foodstar.presentation.home.adapter.MenuAdapter
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.GridSpacingItemDecoration

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels {
        val productDataSource = DummyMenuDataSource()
        val productRepository: MenuRepository = MenuRepositoryImpl(productDataSource)
        val categoryDataSource = DummyCategoryDataSource()
        val categoryRepository: CategoryRepository = CategoryRepositoryImpl(categoryDataSource)
        GenericViewModelFactory.create(HomeViewModel(categoryRepository, productRepository))
    }

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter {

        }
    }

    private val menuAdapter: MenuAdapter by lazy {
        MenuAdapter {
            DetailMenuActivity.startActivity(requireContext(), it)
        }
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
        bindCategoryList(viewModel.getCategories())
        bindMenuList(viewModel.getMenus())
    }

    private fun bindCategoryList(data: List<Category>) {
        binding.rvCategory.apply {
            adapter = categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun bindMenuList(data: List<Menu>) {

        binding.rvCatalog.apply {
            adapter = menuAdapter

        }
        menuAdapter.submitData(data)
    }
}
