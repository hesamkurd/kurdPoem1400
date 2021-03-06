package com.example.kurdpoem.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kurdpoem.R
import com.example.kurdpoem.adapter.AllBooksAdapter
import com.example.kurdpoem.databinding.FragmentAllBooksBinding
import com.example.kurdpoem.model.AllBooksModel
import com.example.kurdpoem.viewmodel.ViewModel


class AllBooksFragment : Fragment() {

    private lateinit var binding: FragmentAllBooksBinding
    private lateinit var viewModel: ViewModel
    private lateinit var allBooksAdapter: AllBooksAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_all_books, container, false)
        binding = FragmentAllBooksBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        binding.recyclerAllBooks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAllBooks.hasFixedSize()

        binding.edtSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                allBooksAdapter.filter.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewModel.getAllBooksListViewModel().observe(viewLifecycleOwner , {

            allBooksAdapter = AllBooksAdapter(requireContext(),
                it as ArrayList<AllBooksModel>, IItemClickListener = {

                view, listBook ->

                val id = listBook.id
                val name = listBook.name

                val bundle= Bundle()
                bundle.putString("id", listBook.id)
                bundle.putString("name", listBook.name)

                Navigation.findNavController(binding.recyclerAllBooks).navigate(R.id.action_allBooksFragment_to_bookDetailFragment, bundle)
            })
            binding.recyclerAllBooks.adapter = allBooksAdapter
        })



        return binding.root
    }


}