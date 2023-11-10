package com.example.laboratorio11b.repository

import com.example.laboratorio11b.model.PokemonResponse
import com.example.laboratorio11b.service.RetrofitInstance

class PokemonRepository {
    private val pokemonService = RetrofitInstance.pokemonService

    suspend fun getPokemon(pokemonNumber: Int): PokemonResponse {
        return pokemonService.getPokemon(pokemonNumber)
    }
}

