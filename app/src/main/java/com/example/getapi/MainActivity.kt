package com.example.getapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getapi.adapter.GithubAdapter
import com.example.getapi.databinding.ActivityMainBinding
import com.example.getapi.model.GithubResponse
import com.example.getapi.viewmodel.GithubViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var githubviewmodel:GithubViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        initGithubAPI()
    }

    fun initGithubAPI(){
        githubviewmodel=ViewModelProvider(this).get(GithubViewModel::class.java)
        githubviewmodel.getresponseDetail()
        githubviewmodel.data.observe(this, Observer {
           initAdapter(it)
        })
    }

    fun initAdapter(data:List<GithubResponse>){
      binding.rv.layoutManager=LinearLayoutManager(this)
        val adapter=GithubAdapter(data)
        binding.rv.adapter=adapter
    }
}