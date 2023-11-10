package com.example.laboratorio11b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio11b.ui.theme.Laboratorio11bTheme
import com.example.laboratorio11b.view.PokemonScreen
import com.example.laboratorio11b.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    private val viewModel : PokemonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonScreen(viewModel)
        }
    }
}
