package com.example.kurdpoem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.kurdpoem.R
import com.example.kurdpoem.databinding.FragmentLoginBinding
import com.example.kurdpoem.viewmodel.ViewModel


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        binding.btnGoToRegister.setOnClickListener {

            Navigation.findNavController(binding.mainNavigation).navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            val phone = binding.txtPhone.text.toString()
            val password = binding.txtPhone.text.toString()

            if (phone.isEmpty() || password.isEmpty()){

                Toast.makeText(requireContext(), "تکایە هەموو بەشەکان پڕ کەنەوە", Toast.LENGTH_SHORT).show()
            }else{

                Toast.makeText(requireContext(), "فەرموون", Toast.LENGTH_SHORT).show()
                viewModel.getSendLogin(phone, password).observe(viewLifecycleOwner,{

                })
                Navigation.findNavController(binding.mainNavigation).navigate(R.id.action_loginFragment_to_profileFragment)

            }

        }

        return binding.root
    }


}