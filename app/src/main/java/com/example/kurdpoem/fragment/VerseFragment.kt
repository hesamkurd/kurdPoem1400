package com.example.kurdpoem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kurdpoem.adapter.VerseAdapter
import com.example.kurdpoem.adapter.VerseDetailAdapter
import com.example.kurdpoem.databinding.FragmentVerseBinding
import com.example.kurdpoem.viewmodel.ViewModel


class VerseFragment : Fragment() {

    private lateinit var binding: FragmentVerseBinding
    private lateinit var verseDetailAdapter: VerseDetailAdapter
    private lateinit var verseAdapter: VerseAdapter
    private lateinit var viewModel: ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_verse, container, false)

        binding = FragmentVerseBinding.inflate(inflater, container,false)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        val id = arguments?.getString("id")!!
        val name = arguments?.getString("name")






        binding.txtName.text = name

        binding.recyclerVerseDetail.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerVerseDetail.hasFixedSize()

        viewModel.getVerseDetailViewModel(id).observe(viewLifecycleOwner, {

            verseDetailAdapter = VerseDetailAdapter(requireContext(),it)
            binding.recyclerVerseDetail.adapter = verseDetailAdapter
        })

        binding.recyclerVerse.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerVerse.hasFixedSize()

        viewModel.getVerseViewModel(id).observe(viewLifecycleOwner , {

            verseAdapter = VerseAdapter(requireContext(),it)
            binding.recyclerVerse.adapter = verseAdapter
        })


        return binding.root
    }


}