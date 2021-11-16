package com.example.kurdpoem.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.kurdpoem.R
import com.example.kurdpoem.adapter.AllPoemAdapter
import com.example.kurdpoem.adapter.NewBooksBannerAdapter
import com.example.kurdpoem.adapter.NewsBannerAdapter
import com.example.kurdpoem.databinding.FragmentFavoriteBinding
import com.example.kurdpoem.databinding.FragmentHomeBinding
import com.example.kurdpoem.model.AllPoemModel
import com.example.kurdpoem.model.PoemDetailModel
import com.example.kurdpoem.viewmodel.ViewModel

class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private lateinit var newsBannerAdapter: NewsBannerAdapter
    private lateinit var allPoemAdapter: AllPoemAdapter
    private lateinit var newBooksBannerAdapter: NewBooksBannerAdapter
    private lateinit var viewModel: ViewModel
    private lateinit var sliderHandler: Handler
    private lateinit var runnable: Runnable
    private var id: String? = null

    private lateinit var data_full: List<AllPoemModel>




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]




        viewModel.getNewsBannerViewModel().observe(viewLifecycleOwner, {

            newsBannerAdapter = NewsBannerAdapter(requireContext(), it)
            binding.imageSlider.adapter = newsBannerAdapter

            binding.imageSlider.clipToPadding = false
            binding.imageSlider.clipChildren = false
            binding.imageSlider.offscreenPageLimit = 3
            binding.imageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(40))
            compositePageTransformer.addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }


            binding.imageSlider.setPageTransformer(compositePageTransformer)
            sliderHandler = Handler()
            runnable = Runnable {
                // binding.viewPager.currentItem = binding.viewPager.currentItem + 1
                if (binding.imageSlider.currentItem < it.size - 1) {
                    binding.imageSlider.currentItem = binding.imageSlider.currentItem + 1
                } else {
                    binding.imageSlider.currentItem = 0
                }
            }

            binding.imageSlider.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {

                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        sliderHandler.removeCallbacks(runnable)
                        sliderHandler.postDelayed(runnable, 3000)
                    }
                })


        })


        binding.recyclerPoem.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPoem.hasFixedSize()

        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                allPoemAdapter.filter.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.txtGoFragmentAllBooks.setOnClickListener {
            Navigation.findNavController(binding.mainLinearLayout)
                .navigate(R.id.action_homeFragment_to_allBooksFragment)
        }

        data_full = ArrayList()
        binding.btnSort.setOnClickListener {

            val option = arrayOf("ئەلفوبێ", "مێژوو")

            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("ریز کردن بە")
                .setItems(option) { dialogInterFace, i ->
                    if (i == 0) {
                        dialogInterFace.dismiss()
                        data_full.sortedBy { it.name }
                        allPoemAdapter.notifyDataSetChanged()

                    } else if (i == 1) {
                        dialogInterFace.dismiss()
                        data_full.sortedByDescending { it.name }
                        allPoemAdapter.notifyDataSetChanged()

                    }
                }.show()


        }


        viewModel.getAllPoemViewModel().observe(viewLifecycleOwner, {

            allPoemAdapter = AllPoemAdapter(requireContext(),
                it as ArrayList<AllPoemModel>, IItemClickListener = {

                        view, listPoem ->

                    val name = listPoem.name
                    val year = listPoem.year
                    val id = listPoem.id

                    val list_data = AllPoemModel(id, name, year)

                    val action = HomeFragmentDirections.actionHomeFragmentToPoemFragment()



                    val bundle = Bundle()
                    bundle.putString("id", id)
                    bundle.putString("name", listPoem.name)
                    bundle.putString("year", listPoem.year)

                    Navigation.findNavController(binding.recyclerPoem)
                        .navigate(R.id.action_homeFragment_to_poemFragment, bundle)

                })

            binding.recyclerPoem.adapter = allPoemAdapter

        })

        binding.recyclerNewBooks.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerNewBooks.hasFixedSize()
        viewModel.getAllBooksViewModel().observe(viewLifecycleOwner, {

            newBooksBannerAdapter = NewBooksBannerAdapter(
                requireContext(),
                it,
                IItemClickListener = { view, listBook ->

                    val name = listBook.name
                    val poem = listBook.poem
                    val id = listBook.id

                    val bundle = Bundle()
                    bundle.putString("id", id)
                    bundle.putString("name", listBook.name)
                    bundle.putString("poem", listBook.poem)

                    Navigation.findNavController(binding.recyclerNewBooks)
                        .navigate(R.id.action_homeFragment_to_bookDetailFragment, bundle)
                })
            binding.recyclerNewBooks.adapter = newBooksBannerAdapter
        })



        return binding.root
    }

}