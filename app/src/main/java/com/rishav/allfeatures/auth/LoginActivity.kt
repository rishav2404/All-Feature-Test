package com.rishav.allfeatures.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rishav.allfeatures.R
import com.rishav.allfeatures.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var databaseReference: DatabaseReference

    companion object {
        const val KEY1 = "com.rishav.allfeatures.auth.LoginActivity.mail"
        const val KEY2 = "com.rishav.allfeatures.auth.LoginActivity.name"
        const val KEY3 = "com.rishav.allfeatures.auth.LoginActivity.uniqueId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener{
            // take reference till node "Users"
            val uniqueId = binding.eTUsernameLogin.text.toString()
            if (uniqueId.isNotEmpty()){
                readData(uniqueId)   //ftn created to read data from firebase
            }else{
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        // to check for existing value
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            // check if user exists
            if (it.exists()){
                // welcome user in app with intent and also pass user data
                val email = it.child("email").value
                val name = it.child("name").value
                val userId = it.child("uniqueId").value

                val intentWelcome  = Intent(this, HomeActivity::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, userId.toString())
                startActivity(intentWelcome)
            } else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }


        }.addOnFailureListener{
            Toast.makeText(this, "Failed to read data from DB", Toast.LENGTH_SHORT).show()
        }
    }
}
