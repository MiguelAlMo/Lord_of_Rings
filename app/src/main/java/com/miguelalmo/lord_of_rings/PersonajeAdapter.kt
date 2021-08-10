package com.miguelalmo.lord_of_rings

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguelalmo.lord_of_rings.databinding.ItemPersonajeBinding

class PersonajeAdapter : RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {

    private var personList = listOf<Personaje>()

    class PersonajeViewHolder(val itemBinding: ItemPersonajeBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val itemBinding = ItemPersonajeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonajeViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val person = personList[position]
        holder.itemBinding.imageView.setImageResource(person.imageId)
        holder.itemBinding.tvNombre.text = person.name
        holder.itemBinding.tvRaza.text = person.race
        holder.itemBinding.root.setOnClickListener {
            val intent = Intent(holder.itemBinding.root.context, PersonajeActivity::class.java)
            intent.putExtra(MainActivity.VALOR1,person.name)
            intent.putExtra(MainActivity.VALOR2,person.biography)
            intent.putExtra(MainActivity.VALOR3,person.imageId)
            holder.itemBinding.root.context.startActivity(intent)
        }
    }

    fun updatePersonajes (personList : List<Personaje>) {
        this.personList = personList
        notifyDataSetChanged()
    }
}