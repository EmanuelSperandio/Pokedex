package com.esperandio.pokedex.api

import com.esperandio.pokedex.api.model.PokemonApiResult
import com.esperandio.pokedex.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{id}")
    fun getPokemon(@Path ("id") id: Int): Call<PokemonApiResult>

}