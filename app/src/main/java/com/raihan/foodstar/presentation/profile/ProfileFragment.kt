package com.raihan.foodstar.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.CircleCropTransformation
import com.raihan.foodstar.R
import com.raihan.foodstar.databinding.FragmentProfileBinding
import com.raihan.foodstar.utils.hideKeyboard

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        observeEditMode()
        hideKeyboard()
        observeProfileDataImage()
    }

    private fun observeProfileDataImage() {
        viewModel.profileData.observe(viewLifecycleOwner) {
            binding.layoutProfile.ivProfile.load(it.profileImgUrl) {
                crossfade(true)
                error(R.drawable.ic_profile)
                transformations(CircleCropTransformation())
            }
            binding.layoutProfile.usernameEditText.setText(it.username)
            binding.layoutProfile.emailEditText.setText(it.email)
            binding.layoutProfile.phoneEditNumber.setText(it.phoneNumber)
        }
    }

    private fun setClickListener() {
        binding.layoutProfile.btnEditProfile.setOnClickListener {
            viewModel.changeEditMode()
        }
    }

    private fun observeEditMode() {
        viewModel.isEditMode.observe(viewLifecycleOwner) {
            binding.layoutProfile.usernameEditText.isEnabled = it
            binding.layoutProfile.emailEditText.isEnabled = it
            binding.layoutProfile.phoneEditNumber.isEnabled = it
        }
    }

}