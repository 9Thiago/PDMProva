package com.example.provaconcess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

class StatsActv : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StatsContent() }
    }

    @Composable
    fun StatsContent() {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Statisticas e Grafico Pizza"
            )
        }
    }
}