package com.example.laboratorio11b.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.laboratorio11b.model.PokemonResponse
import com.example.laboratorio11b.viewmodel.PokemonViewModel

@Composable
fun PokemonScreen(viewModel: PokemonViewModel) {
    val pokemones by viewModel.pokemon.observeAsState(null)
    var pokemonNumber by remember { mutableStateOf("1") }

    Column {
        TextField(
            value = pokemonNumber,
            onValueChange = {
                // Validamos para que solo se permitan números
                if (it.isDigitsOnly()) {
                    pokemonNumber = it
                }
            },
            label = { Text("Número del Pokémon") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                viewModel.fetchPokemon(pokemonNumber.toInt())
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Obtener Información")
        }


        if (pokemones == null) {
            Text(text = "Loading...")
        } else {
            PokemonItem(pokemones!!)
        }
    }
}


@Composable
fun PokemonItem(pokemon: PokemonResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Información del Pokémon:",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Nombre: ${pokemon.forms.getOrNull(0)!!.name}\n"+
                        "Habilidades:"
            )
            // Itera sobre las habilidades y muestra sus nombres
            for (ability in pokemon.abilities) {
                Text(
                    text = "- ${ability.ability.name}",
                    style = TextStyle(fontSize = 14.sp)
                )
            }

        }
    }
}
