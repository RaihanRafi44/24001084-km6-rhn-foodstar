package com.raihan.foodstar.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.raihan.foodstar.R
import com.raihan.foodstar.data.datasource.auth.AuthDataSource
import com.raihan.foodstar.data.datasource.auth.FirebaseAuthDataSource
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.data.repository.UserRepositoryImpl
import com.raihan.foodstar.data.source.firebase.FirebaseService
import com.raihan.foodstar.data.source.firebase.FirebaseServiceImpl
import com.raihan.foodstar.databinding.FragmentProfileBinding
import com.raihan.foodstar.presentation.main.MainActivity
import com.raihan.foodstar.utils.GenericViewModelFactory
import com.raihan.foodstar.utils.proceedWhen

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels {
        val s: FirebaseService = FirebaseServiceImpl()
        val ds: AuthDataSource = FirebaseAuthDataSource(s)
        val r: UserRepository = UserRepositoryImpl(ds)
        GenericViewModelFactory.create(ProfileViewModel(r))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showUserData()
        setClickListener()
        observeEditMode()
    }

    private fun doEditProfile(){
        if(checkNameValidation()){
            val fullName = binding.layoutProfile.etName.text.toString().trim()
            proceedEdit(fullName)
        }
    }
    private fun proceedEdit(fullName: String) {
        viewModel.updateProfileName(fullName = fullName).observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.layoutProfile.pbLoading.isVisible = false
                    binding.layoutProfile.btnSaveProfile.isVisible = true
                    Toast.makeText(requireContext(), "Pengubahan data profil sukses", Toast.LENGTH_SHORT).show()
                    binding.layoutProfile.btnSaveProfile.isEnabled = false
                },
                doOnError = {
                    binding.layoutProfile.pbLoading.isVisible = false
                    binding.layoutProfile.btnSaveProfile.isVisible = true
                    Toast.makeText(requireContext(), "Pengubahan data profil gagal", Toast.LENGTH_SHORT).show()

                },
                doOnLoading = {
                    binding.layoutProfile.pbLoading.isVisible = true
                    binding.layoutProfile.btnSaveProfile.isVisible = false
                }
            )
        }
    }


    private fun requestChangePassword() {
        viewModel.createChangePwdRequest()
        val dialog = buildChangePasswordDialog("Reset password akan dikirimkan ke email ${viewModel.getCurrentUser()?.email}. Harap periksa inbox atau folder spam anda.")
        dialog.show()
    }

    private fun buildChangePasswordDialog(message: String): AlertDialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setMessage(message)
        dialogBuilder.setPositiveButton(
            "Oke"
        ) { dialog, id ->
            // Dismiss dialog on button click
        }
        return dialogBuilder.create()
    }



    private fun showUserData() {
        viewModel.getCurrentUser()?.let {
            binding.layoutProfile.etName.setText(it.fullName)
            binding.layoutProfile.etEmail.setText(it.email)
        }
    }

    private fun checkNameValidation(): Boolean {
        val fullName = binding.layoutProfile.etName.text.toString().trim()
        return if (fullName.isEmpty()) {
            binding.layoutProfile.tilName.isErrorEnabled = true
            binding.layoutProfile.tilName.error = getString(R.string.text_error_name_cannot_empty)
            false
        } else {
            binding.layoutProfile.tilName.isErrorEnabled = false
            true
        }
    }
    private fun observeEditMode() {
        viewModel.isEditMode.observe(viewLifecycleOwner) {
            binding.layoutProfile.etName.isEnabled = it
            binding.layoutProfile.etEmail.isEnabled = it
        }
    }

    private fun setClickListener() {
        binding.layoutProfile.btnEditProfile.setOnClickListener {
            viewModel.changeEditMode()
        }
        binding.layoutProfile.btnSaveProfile.setOnClickListener {
            doEditProfile()
        }
        binding.layoutProfile.btnLogout.setOnClickListener {
            showLogoutConfirmationDialog()
        }
        binding.layoutProfile.btnChangePassword.setOnClickListener {
            requestChangePassword()
        }
    }

    private fun showLogoutConfirmationDialog() {
        val confirmationDialog = buildConfirmationDialog()
        confirmationDialog.show()
    }

    private fun buildConfirmationDialog(): AlertDialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setMessage("Apakah kamu ingin logout?")
        dialogBuilder.setPositiveButton(
            "Ya"
        ) { dialog, id ->
            performLogout()
            navigateToMenu()
        }
        dialogBuilder.setNegativeButton(
            "Tidak"
        ) { dialog, id ->
            // Do nothing, user cancels logout
        }
        return dialogBuilder.create()
    }

    private fun performLogout() {
        viewModel.doLogout()
    }

    private fun navigateToMenu() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }


}