package com.example.mvvmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.example.mvvmapp.R
import com.example.mvvmapp.databinding.ActivityMainBinding
import com.example.mvvmapp.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private val model: CityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this, Observer { city ->
            binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.cityNameTV.text = city.name
            binding.cityPopulationTV.text = city.population.toString()
        })
    }
}