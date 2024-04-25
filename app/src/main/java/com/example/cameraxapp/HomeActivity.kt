package com.example.cameraxapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.cameraxapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set background color
        binding.root.setBackgroundColor(resources.getColor(R.color.splash_background_color))

        // click listener for open camera
        binding.openCameraButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // click listener for view images
        binding.viewImagesButton.setOnClickListener {
            startActivity(Intent(this, ImageGalleryActivity::class.java))
        }

        // Load animation from XML
        val hoverAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.hover_animation)

        // Start animation for logo
        binding.logoImageView.startAnimation(hoverAnimation)
    }
}