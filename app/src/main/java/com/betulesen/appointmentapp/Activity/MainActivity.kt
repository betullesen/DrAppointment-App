package com.betulesen.appointmentapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulesen.appointmentapp.Adapter.DoctorsAdapter
import com.betulesen.appointmentapp.R
import com.betulesen.appointmentapp.ViewModel.MainViewModel
import com.betulesen.appointmentapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        initNearByDoctor()


    }

    private fun initNearByDoctor() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity,{
                topView.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                topView.adapter = DoctorsAdapter(it)
                progressBar.visibility = View.GONE
            })
        }
    }
}