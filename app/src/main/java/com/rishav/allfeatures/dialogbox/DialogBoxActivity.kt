package com.rishav.allfeatures.dialogbox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.R
import com.rishav.allfeatures.databinding.ActivityDialogBoxBinding

class DialogBoxActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDialogBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btn1.setOnClickListener{

            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure ?")
            builder1.setMessage("Do you really want to close the app ?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                // what actions should be perform when YES is clicked
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                // what actions should be perform when NO is clicked

            })
            builder1.show()
        }


        binding.btn2.setOnClickListener{
            val options = arrayOf("Ice", "Hot", "Cold")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Choose your favorite")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                // what actions should be perform when option is clicked
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                // what actions should be perform when YES is clicked
            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                // what actions should be perform when NO is clicked
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener{
            val options = arrayOf("Ice", "Hot", "Cold")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Choose your favorite")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                // what actions should be perform when option is clicked
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                // what actions should be perform when YES is clicked
            })
            builder3.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                // what actions should be perform when NO is clicked
            })
            builder3.show()
        }
    }
}