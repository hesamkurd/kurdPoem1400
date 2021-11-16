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
import com.example.kurdpoem.databinding.FragmentRegisterBinding
import com.example.kurdpoem.model.UserDataModel
import com.example.kurdpoem.viewmodel.ViewModel

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: ViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_register, container, false)

        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        binding.btnGoToLogin.setOnClickListener {
            Navigation.findNavController(binding.mainNavigation).navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val phone = binding.txtPhone.text.toString()
            val password = binding.txtPhone.text.toString()



            if (email.isEmpty() || phone.isEmpty() || password.isEmpty()){

                Toast.makeText(requireContext(), "تکایە هەموو بەشەکان پڕ کەنەوە", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.getSendRegister(email, phone, password).observe(viewLifecycleOwner,{


                    Toast.makeText(requireContext(), "ناونووسی  بە باشی ئەنجام درا", Toast.LENGTH_SHORT).show()

                })

            }



        }




        return binding.root
    }


}