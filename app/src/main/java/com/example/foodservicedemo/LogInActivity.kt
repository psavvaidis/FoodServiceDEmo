package com.example.foodservicedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import com.example.foodservicedemo.models.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
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
//                    Log.i("User Credentials", "phone : ${edtPhone.text.toString()}, password: ${edtPassword.text.toString()}")
                    val user: User? = snapshot.child(edtPhone.text.toString()).getValue<User>()
                        user ?: Toast.makeText(this@LogInActivity, "User Doesn't exist", Toast.LENGTH_LONG).show()

//                    Log.i("User Db Info", "phone : ${user?.Password}, name: ${user?.Name}")

                    if (user!!.Password == edtPassword.text.toString()){
                        Toast.makeText(this@LogInActivity, "Logged In Successfully", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(this@LogInActivity, "Couldn't Log In", Toast.LENGTH_LONG).show()
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}
