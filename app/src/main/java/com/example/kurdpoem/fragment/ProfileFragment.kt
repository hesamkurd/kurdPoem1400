package com.example.kurdpoem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.FragmentPoemBinding
import com.example.kurdpoem.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)

        binding = FragmentProfileBinding.inflate(inflater, container, false)


        binding.txtLogin.setOnClickListener {
            Navigation.findNavController(binding.mainNavigation).navigate(R.id.action_profileFragment_to_loginFragment)
        }

        return binding.root
    }


}