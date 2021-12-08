package com.example.vardhmanjewellers

import adapter.myAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.vardhmanjewellers.databinding.ActivityRingssectionBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_ringssection.*

class ringssection : AppCompatActivity() {
    lateinit var dbred: DatabaseReference
    lateinit var orecyclerview: RecyclerView
    lateinit var myadapter: adapter
    lateinit var binding: ActivityRingssectionBinding
    lateinit var db: FirebaseFirestore
    lateinit var arrylist: ArrayList<jewelrrydata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRingssectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_ringssection)
       binding.recyclererre.layoutManager=GridLayoutManager(this,2)
        db = FirebaseFirestore.getInstance()
        getdata()
    }

    private fun getdata() {
        db.collection("goldrings").get().addOnSuccessListener { documents ->

            for (document in documents) {
                val user = documents.toObjects(jewelrrydata::class.java)
                binding.recyclererre.adapter = adapter(this, user)


            }
        }








    }
}



