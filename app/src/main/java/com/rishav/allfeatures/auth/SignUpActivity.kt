package com.rishav.allfeatures.auth

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rishav.allfeatures.R
import com.rishav.allfeatures.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignUpBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUpButton = findViewById<Button>(R.id.btnSignUp)
        val eTName =  findViewById<TextInputEditText>(R.id.eTName)
        val eTEmail =  findViewById<TextInputEditText>(R.id.eTEmail)
        val eTUsername =  findViewById<TextInputEditText>(R.id.eTUsername)
        val eTPassword =  findViewById<TextInputEditText>(R.id.eTPassword)
        val tvLogin =  findViewById<TextView>(R.id.tvSignInText)


        tvLogin.setOnClickListener{
            val openLoginIntent = Intent(this, LoginActivity::class.java)
            startActivity(openLoginIntent)
        }

        signUpButton.setOnClickListener{
            val name = eTName.text.toString()
            val email = eTEmail.text.toString()
            val uniqueId = eTUsername.text.toString()
            val password = eTPassword.text.toString()

            val user = User(name, email, uniqueId, password)
            database = FirebaseDatabase.getInstance().getReference("Users")
            if(binding.checkBox.isChecked){
                database.child(uniqueId).setValue(user)
                .addOnSuccessListener {
                    // to clear fields after registration
                    eTName.text?.clear()
                    eTEmail.text?.clear()
                    eTUsername.text?.clear()
                    eTPassword.text?.clear()
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                // change the color of checkbox to red and toast message
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }

    }
}