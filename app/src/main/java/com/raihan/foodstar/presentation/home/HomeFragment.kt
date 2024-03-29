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
import androidx.recyclerview.widget.LinearLayoutManager
import com.raihan.foodstar.R
import com.raihan.foodstar.data.datasource.category.DummyCategoryDataSource
import com.raihan.foodstar.data.datasource.menu.DummyMenuDataSource
import com.raihan.foodstar.data.datasource.menu.MenuDataSource
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
import com.raihan.foodstar.presentation.home.adapter.OnItemClickedListener
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.GridSpacingItemDecoration

class HomeFragment : Fragment() {
    private var menuAdapter: MenuAdapter? = null
    private var isUsingGridMode: Boolean = true
    private val dataSource: MenuDataSource by lazy {
        DummyMenuDataSource()
    }
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels {
        val menuDataSource = DummyMenuDataSource()
        val menuRepository: MenuRepository = MenuRepositoryImpl(menuDataSource)
        val categoryDataSource = DummyCategoryDataSource()
        val categoryRepository: CategoryRepository = CategoryRepositoryImpl(categoryDataSource)
        GenericViewModelFactory.create(HomeViewModel(categoryRepository, menuRepository))
    }
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter {

        }
    }
    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            changeBtnIcon()
            bindMenuList(isUsingGridMode)
            setClickAction()
        }
    }


    private fun changeBtnIcon() {
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
        bindCategoryList(viewModel.getCategories())
        bindMenuList(true)
        setClickAction()
    }

    private fun bindCategoryList(data: List<Category>) {
        binding.rvCategory.apply {
            adapter = this@HomeFragment.categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun bindMenuList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) MenuAdapter.MODE_GRID else MenuAdapter.MODE_LIST
        menuAdapter =
            MenuAdapter(
                listMode = listMode,
                listener = object : OnItemClickedListener<Menu> {
                    override fun onItemClicked(item: Menu) {
                        navigateToDetail(item)
                    }
                },
            )
        binding.rvCatalog.apply {
            adapter = this@HomeFragment.menuAdapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        menuAdapter?.submitData(dataSource.getMenus())
    }

    private fun navigateToDetail(item: Menu) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(DetailMenuActivity.EXTRA_MENU, item))
        navController.navigate(R.id.action_menu_tab_home_to_detailMenuActivity, bundle)
    }
}