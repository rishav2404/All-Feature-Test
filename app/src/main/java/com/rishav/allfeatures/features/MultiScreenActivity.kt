package com.rishav.allfeatures.features

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.R
import com.rishav.allfeatures.databinding.ActivityMultiScreenBinding


class MultiScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultiScreenBinding  // [1]---> needed for view Binding

    //creating key  (global...static object)
    companion object {
        const val KEY = "com.rishav.myapplication.MultiScreenActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiScreenBinding.inflate(layoutInflater)    // [2]---> needed for view Binding
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonOrder.setOnClickListener {   // --> [3] Now access id of components using (binding.id)
            val ordersPlaced = binding.eT1.text .toString() + " " +
                    binding.eT2.text.toString() + " " +
                    binding.eT3.text.toString()+ " " +
                    binding.eT4.text.toString()

            intent = Intent(this, OrderActivity::class.java)
            intent.putExtra(KEY,ordersPlaced)
            startActivity(intent)
        }

    }
}