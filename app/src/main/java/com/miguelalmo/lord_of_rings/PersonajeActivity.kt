package com.miguelalmo.lord_of_rings

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.miguelalmo.lord_of_rings.MainActivity.Companion.VALOR1
import com.miguelalmo.lord_of_rings.MainActivity.Companion.VALOR2
import com.miguelalmo.lord_of_rings.MainActivity.Companion.VALOR3
import com.miguelalmo.lord_of_rings.databinding.ActivityPersonajeBinding

class PersonajeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPersonajeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(VALOR1)
        val biography = intent.getStringExtra(VALOR2)
        val image = intent.getIntExtra(VALOR3,R.mipmap.ic_launcher)

        binding.tvName.text = name
        binding.biography.text = biography
        binding.biography.movementMethod = ScrollingMovementMethod()
        binding.imageView2.setImageResource(image)
    }
}