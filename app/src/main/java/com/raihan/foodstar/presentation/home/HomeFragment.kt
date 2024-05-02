package com.raihan.foodstar.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.raihan.foodstar.R
import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.databinding.FragmentHomeBinding
import com.raihan.foodstar.presentation.detailmenu.DetailMenuActivity
import com.raihan.foodstar.presentation.home.adapter.CategoryAdapter
import com.raihan.foodstar.presentation.home.adapter.MenuAdapter
import com.raihan.foodstar.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter {
            proceedMenu(it.name)
        }
    }

    private val menuAdapter: MenuAdapter by lazy {
        MenuAdapter(homeViewModel.getListMode()) {
            navigateToDetail(it)
        }
    }

    private fun showUserData() {
        homeViewModel.getCurrentUser()?.let { user ->
            binding.layoutHead.textName.text =
                getString(R.string.text_username_login, user.fullName)
        }
    }

    private fun setupMenu() {
        binding.rvCatalog.apply {
            adapter = menuAdapter
        }
    }

    private fun proceedCategory() {
        homeViewModel.getCategory().observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.pbLoading.isVisible = false
                    binding.rvCategory.isVisible = true
                    it.payload?.let { data -> bindCategory(data) }
                },
                doOnError = {
                    binding.pbLoading.isVisible = false
                    binding.rvCategory.isVisible = true
                },
                doOnLoading = {
                    binding.pbLoading.isVisible = true
                    binding.rvCategory.isVisible = false
                },
            )
        }
    }

    /*private fun getCategoryData() {
        homeViewModel.getCategory().observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    it.payload?.let { data -> bindCategory(data) }
                }
            )
        }
    }*/

    private fun bindCategory(data: List<Category>) {
        categoryAdapter.submitData(data)
    }

    private fun setupCategory() {
        binding.rvCategory.apply {
            adapter = categoryAdapter
        }
    }

    private fun observeGridMode() {
        homeViewModel.isUsingGridMode.observe(viewLifecycleOwner) { isUsingGridMode ->
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
            homeViewModel.changeListMode()
        }
    }

    private fun changeBtnIcon(isUsingGridMode: Boolean) {
        binding.btnChangeListMode.setIconResource(if (isUsingGridMode) R.drawable.ic_grid_black else R.drawable.ic_list_black)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        showUserData()
        setupCategory()
        setupMenu()
        observeGridMode()
        proceedCategory()
        proceedMenu(null)
        setClickAction()
    }

    private fun proceedMenu(name: String? = null) {
        homeViewModel.getMenu(name).observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.pbLoadingCatalog.isVisible = false
                    binding.rvCatalog.isVisible = true
                    it.payload?.let { data ->
                        bindMenuList(data)
                    }
                },
                doOnError = {
                    binding.pbLoadingCatalog.isVisible = false
                    binding.rvCatalog.isVisible = true
                },
                doOnLoading = {
                    binding.pbLoadingCatalog.isVisible = true
                    binding.rvCatalog.isVisible = false
                },
            )
        }
    }

    private fun bindMenuList(data: List<Menu>) {
        menuAdapter.submitData(data)
    }

    private fun navigateToDetail(item: Menu) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(DetailMenuActivity.EXTRA_MENU, item))
        navController.navigate(R.id.action_menu_tab_home_to_detailMenuActivity, bundle)
    }
}
