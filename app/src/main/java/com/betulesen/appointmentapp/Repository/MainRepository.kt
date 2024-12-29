package com.betulesen.appointmentapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.FirebaseDatabase
import com.betulesen.appointmentapp.Model.DoctorsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase=FirebaseDatabase.getInstance()

    fun load():LiveData<MutableList<DoctorsModel>> {
        val listData=MutableLiveData<MutableList<DoctorsModel>>()
        val ref = firebaseDatabase.getReference("Doctors")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<DoctorsModel>()
                for(childSnapshot in snapshot.children){
                    val item = childSnapshot.getValue(DoctorsModel::class.java)
                    item?.let {lists.add(it)}
                }
                listData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return listData

    }
}