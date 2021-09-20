package com.technipixl.eval4_and_loichubermont

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technipixl.eval4_and_loichubermont.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}