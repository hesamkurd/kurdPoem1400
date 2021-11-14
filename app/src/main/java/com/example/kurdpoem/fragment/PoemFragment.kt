package com.example.kurdpoem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kurdpoem.R
import com.example.kurdpoem.adapter.AllBooksAdapter
import com.example.kurdpoem.adapter.PoemDetailAdapter
import com.example.kurdpoem.databinding.FragmentPoemBinding
import com.example.kurdpoem.model.AllBooksModel
import com.example.kurdpoem.viewmodel.ViewModel

class PoemFragment : Fragment() {

    private lateinit var binding: FragmentPoemBinding
    private lateinit var poemDetailAdapter: PoemDetailAdapter
    private lateinit var allBooksAdapter: AllBooksAdapter
    private lateinit var viewModel: ViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_poem, container, false)

        binding = FragmentPoemBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        val id = arguments?.getString("id")!!
        val name = arguments?.getString("name")
        val year = arguments?.getString("year")

        binding.txtName.text = name
        binding.txtYear.text = year

        binding.recyclerPoemDetail.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPoemDetail.hasFixedSize()

        viewModel.getPoemDetailViewModel(id).observe(viewLifecycleOwner , {

            poemDetailAdapter = PoemDetailAdapter(requireContext(), it)
            binding.recyclerPoemDetail.adapter = poemDetailAdapter

        })

        binding.recyclerBooksOfPoem.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerBooksOfPoem.hasFixedSize()

        viewModel.getBooksOfPoemViewModel(id).observe(viewLifecycleOwner , {

            allBooksAdapter = AllBooksAdapter(requireContext(),
                it as ArrayList<AllBooksModel>, IItemClickListener = {
                    view, listBook ->

                val id = listBook.id
                val name = listBook.name

                val bundle= Bundle()
                bundle.putString("id", listBook.id)
                bundle.putString("name", listBook.name)

                Navigation.findNavController(binding.recyclerBooksOfPoem).navigate(R.id.action_poemFragment_to_bookDetailFragment, bundle)



            })
            binding.recyclerBooksOfPoem.adapter = allBooksAdapter
        })



        return binding.root
    }


}