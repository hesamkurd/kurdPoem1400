package com.example.kurdpoem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.kurdpoem.api.ApiClient
import com.example.kurdpoem.api.ApiService
import com.example.kurdpoem.databinding.ActivityLoginBinding
import com.example.kurdpoem.model.SharedPref
import com.example.kurdpoem.model.UserDataModel
import com.example.kurdpoem.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var request: ApiService? = null
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        request = ApiClient.getApiClient().create(ApiService::class.java)

        sharedPref = SharedPref(this)
        if (sharedPref.isLoggedIn()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {

            val password: String = binding.txtPassword.text.toString()
            val phone: String = binding.txtPhone.text.toString()

            if (password.isEmpty() || phone.isEmpty()) {

                Toast.makeText(this, "پر کنید", Toast.LENGTH_SHORT).show()
            } else {

                loginAccount(phone, password)
            }

        }

        binding.btnGoToRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun loginAccount(phone: String, password: String) {

        val userCall: Call<Users> = request!!.sendLogin(phone, password)
        userCall.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful && response.body()!!.status) {
                    val userDataModel: UserDataModel = response.body()!!.data
                    sharedPref.saveUserData(userDataModel)
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(
                        this@LoginActivity,
                        response.body()!!.message + "",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {

                    Toast.makeText(
                        this@LoginActivity,
                        response.body()!!.message + "",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message + "", Toast.LENGTH_SHORT).show()

            }


        })


    }

}