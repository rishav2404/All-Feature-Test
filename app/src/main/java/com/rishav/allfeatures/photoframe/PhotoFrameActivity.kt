package com.rishav.allfeatures.photoframe

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishav.allfeatures.R
import com.rishav.allfeatures.databinding.ActivityPhotoFrameBinding

class PhotoFrameActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhotoFrameBinding

    var currentImage = 0
    lateinit var image : ImageView
    var names = arrayOf("Rishav0","Rishav1","Rishav2")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPhotoFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.imgBtnPrev.setOnClickListener {
            var idCurrentImageString = "pic$currentImage"
            // convert string id to integer address associated with it
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            // access the image with the id and change it visibility(alpha)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (3 + currentImage - 1)%3

            var idImageToShowString = "pic$currentImage"
            // convert string id to integer address associated with it
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            // access the image with the id and change it visibility(alpha)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            binding.tvName.text = names[currentImage]

        }

        binding.imgBtnNext.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (3 + currentImage + 1)%3
            val idImageToShowString = "pic$currentImage"

            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            binding.tvName.text = names[currentImage]
        }

    }
}