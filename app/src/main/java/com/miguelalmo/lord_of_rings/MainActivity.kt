package com.miguelalmo.lord_of_rings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelalmo.lord_of_rings.databinding.ActivityMainBinding
import com.miguelalmo.lord_of_rings.databinding.ActivityPersonajeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model : MainActivityViewModel
    private lateinit var adapter : PersonajeAdapter
    private var listaPersonajes = listOf<Personaje>()

    companion object {
        const val VALOR1 = "VALOR1"
        const val VALOR2 = "VALOR2"
        const val VALOR3 = "VALOR3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        adapter = PersonajeAdapter()

        listaPersonajes = model.loadPersonajes()

        createRecyclerView()
        // Permite ver los colores de los botones del bottomNavigation
        binding.bottomNavigation.itemIconTintList = null

        binding.bottomNavigation.setOnItemSelectedListener { itemSelected ->
            when (itemSelected.itemId) {
                R.id.all -> adapter.updatePersonajes(listaPersonajes)
                R.id.goods -> adapter.updatePersonajes(listaPersonajes.filter { it.itsGood })
                R.id.villains -> adapter.updatePersonajes(listaPersonajes.filter { !it.itsGood })
            }
            true
        }
        binding.bottomNavigation.menu.findItem(R.id.all).isChecked = true
    }

    private fun createRecyclerView() {
        // Aquií le decimos que ponga los elemento de arriba a abajo.
        binding.rvRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.rvRecyclerView.adapter = adapter
        adapter.updatePersonajes(model.loadPersonajes())
    }

}