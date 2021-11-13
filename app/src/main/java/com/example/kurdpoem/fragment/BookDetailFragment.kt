package com.example.kurdpoem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kurdpoem.R
import com.example.kurdpoem.adapter.BookDetailAdapter
import com.example.kurdpoem.databinding.FragmentBookDetailBinding
import com.example.kurdpoem.viewmodel.ViewModel


class BookDetailFragment : Fragment() {

    private lateinit var binding: FragmentBookDetailBinding
    private lateinit var bookDetailAdapter: BookDetailAdapter
    private lateinit var viewModel: ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_book_detail, container, false)
        binding = FragmentBookDetailBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        val id = arguments?.getString("id")!!
        val name = arguments?.getString("name")
        val poem = arguments?.getString("poem")

        binding.txtName.text = name

        binding.recyclerBookDetail.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerBookDetail.hasFixedSize()

        viewModel.getBookDetailViewModel(id).observe(viewLifecycleOwner , {

            bookDetailAdapter = BookDetailAdapter(requireContext(),it)
            binding.recyclerBookDetail.adapter = bookDetailAdapter
        })



        return binding.root
    }


}