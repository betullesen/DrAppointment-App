package com.betulesen.appointmentapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.betulesen.appointmentapp.Model.DoctorsModel
import com.betulesen.appointmentapp.Repository.MainRepository

class MainViewModel() : ViewModel() {

    private val repository = MainRepository()

    fun loadDoctors() : LiveData<MutableList<DoctorsModel>>{
        return  repository.load()
    }
}