package com.example.kurdpoem.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.kurdpoem.R
import com.example.kurdpoem.adapter.AllPoemAdapter
import com.example.kurdpoem.adapter.NewsBannerAdapter
import com.example.kurdpoem.databinding.FragmentFavoriteBinding
import com.example.kurdpoem.databinding.FragmentHomeBinding
import com.example.kurdpoem.viewmodel.ViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var newsBannerAdapter: NewsBannerAdapter
    private lateinit var allPoemAdapter: AllPoemAdapter
    private lateinit var viewModel: ViewModel
    private lateinit var sliderHandler: Handler
    private lateinit var runnable: Runnable


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        binding.recyclerPoem.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPoem.hasFixedSize()

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
                if (binding.imageSlider.currentItem < it.size -1){
                    binding.imageSlider.currentItem = binding.imageSlider.currentItem +1
                } else {
                    binding.imageSlider.currentItem = 0
                }
            }

            binding.imageSlider.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback(){

                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        sliderHandler.removeCallbacks(runnable)
                        sliderHandler.postDelayed(runnable, 3000)
                    }
                })


        })

        viewModel.getAllPoemViewModel().observe(viewLifecycleOwner , {

            allPoemAdapter = AllPoemAdapter(requireContext(), it)
            binding.recyclerPoem.adapter = allPoemAdapter

        })



        return binding.root
    }
}