package com.nalldev.spotplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nalldev.spotplace.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){
    private val viewModel : MainViewModel by viewModel()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.weather.observe(this) {
            binding.apply {
                tvTemp.text = String.format("%s : %s %s", it[1].name, it[1].value, it[1].unit)
                tvHumidity.text = String.format("%s : %s %s", it[0].name, it[0].value, it[0].unit)
            }
        }
    }
}