package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vardhmanjewellers.R
import adapter.cartadapter
import Model.cartmembers
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_to_cart.*
import kotlinx.android.synthetic.main.activity_favorites.*

class AddToCart : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart)
        db = FirebaseFirestore.getInstance()
        cartkarecyclerview.layoutManager = LinearLayoutManager(this)
        backbutton.setOnClickListener {
            val intent = Intent(this, frontpage::class.java)
            startActivity(intent)
            finish()
        }



        getdata()





    }

    private fun getdata() {

        db.collection("addtocart").get().addOnSuccessListener {

                documents ->


            for (document in documents) {
                val user = documents.toObjects(cartmembers::class.java)
                cartkarecyclerview.adapter = cartadapter(this, user)


            }

        }

    }
}