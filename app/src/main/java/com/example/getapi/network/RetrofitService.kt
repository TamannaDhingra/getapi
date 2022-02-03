package com.example.getapi.network

import com.example.getapi.model.GithubResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    //https://api.github.com/repos/octocat/hello-world/issues
    @GET("/repos/octocat/hello-world/issues")
    fun getData(): Call<List<GithubResponse>>
}