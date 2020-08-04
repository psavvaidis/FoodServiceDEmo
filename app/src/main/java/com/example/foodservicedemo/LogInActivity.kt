package com.example.foodservicedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        db = Firebase.database.reference
        val tableUser = db.child("User")

        btn_log_in.setOnClickListener{
            tableUser.addValueEventListener(object: ValueEventListener{

                override fun onDataChange(snapshot: DataSnapshot) {
                    TODO("Not yet implemented")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}
