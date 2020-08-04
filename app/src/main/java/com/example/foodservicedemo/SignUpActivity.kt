package com.example.foodservicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodservicedemo.models.User
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        db = Firebase.database.reference
        val tableUser = db.child("User")

        btn_sign_up.setOnClickListener {
            tableUser.addValueEventListener(object : ValueEventListener{

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(snapshot: DataSnapshot) {

                    trueOrNull(snapshot.child(edtPhone.text.toString()).exists()) ?: run {
                        val newUser = User(edtName.text.toString(), edtPassword.text.toString())
                        tableUser.child(edtPhone.text.toString()).setValue(newUser)
                        Toast.makeText(this@SignUpActivity, "Successsfully Signed Up", Toast.LENGTH_SHORT).show()
                        intent = Intent(this@SignUpActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    Toast.makeText(this@SignUpActivity, "User Phone number already exists", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    fun trueOrNull(cond: Boolean): Boolean?{
        if (!cond){return null}
        return true
    }
}
