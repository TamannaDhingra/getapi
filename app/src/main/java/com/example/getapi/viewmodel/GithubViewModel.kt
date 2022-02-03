package com.example.getapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getapi.model.GithubResponse
import com.example.getapi.network.RetrofitInstance
import com.example.getapi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class GithubViewModel:ViewModel() {
    private  val data1= MutableLiveData<List<GithubResponse>>()
    val data: LiveData<List<GithubResponse>>
        get() = data1



    fun getresponseDetail()
    {

        RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java).getData().enqueue(object :retrofit2.Callback<List<GithubResponse>>{
            override fun onResponse(
                call: Call<List<GithubResponse>>,
                response: Response<List<GithubResponse>>
            ) {
                data1.postValue(response.body())
            }

            override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {
                Log.d("TAG", "onFailure: Failure DhabaDetailViewModel")
            }
        })

    }

}

