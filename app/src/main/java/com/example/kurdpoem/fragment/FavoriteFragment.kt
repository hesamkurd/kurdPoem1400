package com.example.kurdpoem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kurdpoem.R
import com.example.kurdpoem.adapter.FavoriteListAdapter
import com.example.kurdpoem.api.ApiClient
import com.example.kurdpoem.api.ApiService
import com.example.kurdpoem.databinding.FragmentFavoriteBinding
import com.example.kurdpoem.model.FavoriteListModel
import com.example.kurdpoem.model.Message
import com.example.kurdpoem.model.SharedPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteAdapter: FavoriteListAdapter
    var request: ApiService? = null
    private lateinit var sharedPref: SharedPref
    private lateinit var user_email: String
    private lateinit var listFavorite: List<FavoriteListModel>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_favorite, container, false)
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        request = ApiClient.getApiClient().create(ApiService::class.java)
        sharedPref = SharedPref(requireContext())
        user_email = sharedPref.getUserData()[SharedPref.EMAIL]!!

        binding.recyclerFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFavorite.hasFixedSize()



        val call: Call<List<FavoriteListModel>> = request!!.getListFavorite(user_email)
        call.enqueue(object : Callback<List<FavoriteListModel>> {
            override fun onResponse(
                call: Call<List<FavoriteListModel>>,
                response: Response<List<FavoriteListModel>>
            ) {
                listFavorite = response.body()!!
                favoriteAdapter = FavoriteListAdapter(requireContext(),
                    listFavorite as ArrayList<FavoriteListModel>, IItemClickListener = {
                        view, listFavorite ->

                    val id = listFavorite.id_verse
                    val bundle = Bundle()
                    bundle.putString("id", id)

                    Navigation.findNavController(binding.recyclerFavorite).navigate(R.id.action_favoriteFragment_to_verseFragment , bundle)
                }, object: FavoriteListAdapter.DeleteFavorite{
                    override fun IItemDelete(favoriteListModel: FavoriteListModel) {
                        val deleteCall: Call<Message> = request!!.deleteFavorite(favoriteListModel.favorite_id)
                        deleteCall.enqueue(object : Callback<Message>{
                            override fun onResponse(
                                call: Call<Message>,
                                response: Response<Message>
                            ) {
                                if (response.body()!!.message == "Ok"){
                                    favoriteAdapter.deleteIndex(favoriteListModel)


                                }
                            }

                            override fun onFailure(call: Call<Message>, t: Throwable) {
                                Toast.makeText(requireContext(), t.message+"", Toast.LENGTH_SHORT).show()
                            }


                        })
                    }


                })
                binding.recyclerFavorite.adapter = favoriteAdapter
            }

            override fun onFailure(call: Call<List<FavoriteListModel>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message + "", Toast.LENGTH_SHORT).show()

            }


        })



        return binding.root






    }


}