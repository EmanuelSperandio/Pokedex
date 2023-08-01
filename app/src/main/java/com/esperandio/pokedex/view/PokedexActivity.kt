package com.esperandio.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esperandio.pokedex.R
import com.esperandio.pokedex.api.PokemonRepository
import com.esperandio.pokedex.domain.Pokemon

class PokedexActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)
        recyclerView = findViewById(R.id.rv_pokemons)

        Thread(Runnable {
            loadPokemons()
        }).start()


    }

    private fun loadPokemons() {

        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            val pokemons: List<Pokemon?> = it.map {pokemonResult ->

                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/","")
                    .replace("/","")
                    .toInt()


                val pokemonApiResult = PokemonRepository.getPokemon(number)

                Log.d("pokedexapiresult", pokemonApiResult.toString())

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.sprites
                    )
                }

            }

            val layoutManager = LinearLayoutManager(this)
            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(pokemons)
            }
        }
    }
}