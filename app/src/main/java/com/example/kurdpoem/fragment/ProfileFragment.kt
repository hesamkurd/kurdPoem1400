package com.example.kurdpoem.fragment

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.FragmentPoemBinding
import com.example.kurdpoem.databinding.FragmentProfileBinding
import com.example.kurdpoem.model.SharedPref

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPref: SharedPref



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        sharedPref = SharedPref(requireContext())

        binding.txtName.text = sharedPref.getUserData()[SharedPref.PHONE]
        binding.txtPhone.text = sharedPref.getUserData()[SharedPref.EMAIL]





        return binding.root
    }


}