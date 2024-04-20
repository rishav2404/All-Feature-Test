package com.rishav.allfeatures.alertbox

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.R
import com.rishav.allfeatures.databinding.ActivityAlertBoxBinding

class AlertBoxActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlertBoxBinding

    // a variable of type dialog
    private lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAlertBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)  // set the layout of the dialog
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))   // to set shape background to dialog alert box

        // creating variable for custom_dialogue.xml design
        val buttonGood = dialog.findViewById<Button>(R.id.btnGood)
        val buttonFeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        // set on click listener for buttonGood
        buttonGood.setOnClickListener {
            // close the dialog
            dialog.dismiss()
        }

        // set on click listener for buttonFeedback
        buttonFeedback.setOnClickListener {
            // close the dialog
            dialog.dismiss()
        }

        binding.btnClickMe.setOnClickListener {
            // show the dialog
            dialog.show()
        }

    }
}