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
import coil.load
import coil.transform.CircleCropTransformation
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
import com.raihan.foodstar.utils.hideKeyboard
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
            val email = binding.layoutProfile.etEmail.text.toString().trim()
            proceedEdit(fullName, email)
        }
    }
    private fun proceedEdit(fullName: String, email : String) {
        viewModel.updateProfileName(fullName = fullName).observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.layoutProfile.pbLoading.isVisible = false
                    binding.layoutProfile.btnSaveProfile.isVisible = true
                    Toast.makeText(requireContext(), "Change Profile data Success !", Toast.LENGTH_SHORT).show()
                    showUserData()
                },
                doOnError = {
                    binding.layoutProfile.pbLoading.isVisible = false
                    binding.layoutProfile.btnSaveProfile.isVisible = true
                    Toast.makeText(requireContext(), "Change Profile data Failed !", Toast.LENGTH_SHORT).show()

                },
                doOnLoading = {
                    binding.layoutProfile.pbLoading.isVisible = true
                    binding.layoutProfile.btnSaveProfile.isVisible = false
                }
            )
        }
        viewModel.updateProfileEmail(email = email).observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.layoutProfile.pbLoading.isVisible = false
                    binding.layoutProfile.btnSaveProfile.isVisible = true
                    Toast.makeText(requireContext(), "Change Profile data Success !", Toast.LENGTH_SHORT).show()
                    showUserData()
                },
                doOnError = {
                    binding.layoutProfile.pbLoading.isVisible = false
                    binding.layoutProfile.btnSaveProfile.isVisible = true
                    Toast.makeText(requireContext(), "Change Profile data Failed !", Toast.LENGTH_SHORT).show()

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
        val dialog = AlertDialog.Builder(requireContext())
            .setMessage("Change password request sended to your email : ${viewModel.getCurrentUser()?.email} Please check to your inbox or spam")
            .setPositiveButton(
                "Okay"
            ) { dialog, id ->

            }.create()
        dialog.show()
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
        doEditProfile()
    }

    private fun setClickListener() {
        binding.layoutProfile.btnEditProfile.setOnClickListener {
            viewModel.changeEditMode()
        }
        binding.layoutProfile.btnLogout.setOnClickListener {
            doLogout()
        }
        binding.layoutProfile.btnResetPassword.setOnClickListener {
            requestChangePassword()
        }
    }

    private fun navigateToMenu() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    private fun doLogout() {
        val dialog = AlertDialog.Builder(requireContext()).setMessage("Do you want to logout ?")
            .setPositiveButton(
                "Yes"
            ) { dialog, id ->
                viewModel.doLogout()
                navigateToMenu()
            }
            .setNegativeButton(
                "No"
            ) { dialog, id ->
                //no-op , do nothing
            }.create()
        dialog.show()
    }

}