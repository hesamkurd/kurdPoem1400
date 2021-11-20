package com.example.kurdpoem.fragment

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kurdpoem.adapter.VerseAdapter
import com.example.kurdpoem.adapter.VerseDetailAdapter
import com.example.kurdpoem.api.ApiClient
import com.example.kurdpoem.api.ApiService
import com.example.kurdpoem.databinding.FragmentVerseBinding
import com.example.kurdpoem.model.FavoriteListModel
import com.example.kurdpoem.model.Message
import com.example.kurdpoem.model.SharedPref
import com.example.kurdpoem.viewmodel.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class VerseFragment : Fragment() {

    private lateinit var binding: FragmentVerseBinding
    private lateinit var verseDetailAdapter: VerseDetailAdapter
    private lateinit var verseAdapter: VerseAdapter
    private lateinit var viewModel: ViewModel

    var request: ApiService? = null
    private lateinit var sharedPref: SharedPref
    private lateinit var user_email: String

    private var ourFontSize = 14f


    private var favorite_id: String? =null
   private var favoriteListModel: FavoriteListModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_verse, container, false)

        binding = FragmentVerseBinding.inflate(inflater, container,false)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        request = ApiClient.getApiClient().create(ApiService::class.java)
        sharedPref = SharedPref(requireContext())
        user_email = sharedPref.getUserData()[SharedPref.EMAIL]!!



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



        binding.imgFavorite.setOnClickListener {
            sendToFavorite(id, user_email)
        }


        /*
        binding.imgFavoriteDelete.setOnClickListener {
            val deleteCall: Call<Message> = request!!.deleteFavorite(favoriteListModel!!.favorite_id)
            deleteCall.enqueue(object : Callback<Message>{
                override fun onResponse(call: Call<Message>, response: Response<Message>) {
                    if (response.body()!!.message == "Ok"){
                        Toast.makeText(requireContext(), response.body()!!.message, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Message>, t: Throwable) {
                    Toast.makeText(requireContext(), t.message+"", Toast.LENGTH_SHORT).show()

                }


            })
        }

         */





        return binding.root
    }

    private fun deleteFromFavorite(favoriteListModel: FavoriteListModel?) {



    }


    private fun sendToFavorite(id: String, user_email: String)  {

        val favoriteCall: Call<Message> = request!!.sendToFavorite(id , user_email)
        favoriteCall.enqueue(object : Callback<Message>{
            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                if (response.isSuccessful && response.body()!!.status){

                    Toast.makeText(requireContext(), response.body()!!.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(requireContext(), t.message+"", Toast.LENGTH_SHORT).show()
            }


        })

    }


}