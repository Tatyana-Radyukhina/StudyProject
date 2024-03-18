package com.example.studyproject

import BreweriesDTO
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studyproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openbrewerydb.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            val service = retrofit.create(BreweryInterface::class.java)


            binding.button.setOnClickListener {
                service.getBreweries("Austin", "United States", "Texas").enqueue(object :
                    Callback<BreweriesDTO> {
                    override fun onResponse(
                        call: Call<BreweriesDTO>,
                        response: Response<BreweriesDTO>
                    ) {
                        println("!!! ${response.body()}")
                    }

                    override fun onFailure(call: Call<BreweriesDTO>, t: Throwable) {
                        println("ошибка")
                        t.printStackTrace()
                    }
                })
            }


    }
}