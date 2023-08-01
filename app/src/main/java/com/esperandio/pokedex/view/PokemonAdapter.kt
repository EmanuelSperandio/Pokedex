package com.esperandio.pokedex.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esperandio.pokedex.R
import com.esperandio.pokedex.domain.Pokemon

class PokemonAdapter (
    private val items: List<Pokemon?>
        ) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Pokemon?) = with(itemView){
            val pokemonSprite = findViewById<ImageView>(R.id.pokemon_sprite)
            val pokemonName = findViewById<TextView>(R.id.pokemon_name)
            val pokemonID = findViewById<TextView>(R.id.pokemon_id)

            item?.let {
                pokemonID.text = "#${item.formattedNumber}"
                pokemonName.text = item.name
                var pokeSprite = item.sprite.toString()
                var pokeSpriteFinal : String = pokeSprite.replace("PokemonSprite(front_default=","").replace(")","")
                Glide.with(itemView.context).load(pokeSpriteFinal).into(pokemonSprite)
            }

        }

    }

}