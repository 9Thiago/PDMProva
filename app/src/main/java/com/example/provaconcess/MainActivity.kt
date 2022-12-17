package com.example.provaconcess

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.provaconcess.navigation.BottomNavigationBar
import com.example.provaconcess.navigation.NavigationSetup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent();

        }
    }

    @Composable
    fun MainContent() {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Center
                        ) {
                            Text(
                                "Concessionária PDM"
                            )
                        }
                    },
                    backgroundColor = Color.Yellow,

                    )
            },
            bottomBar = { BottomNavigationBar(navController) }
        ) { NavigationSetup(navController = navController) }
    }



    @Composable
    fun NextPageBtn() {
        FloatingActionButton(onClick = { showNextPage() }) {
            Icon(Icons.Filled.PlayArrow, contentDescription = "icone")
        }
    }

    private fun showNextPage() {
        startActivity(Intent(this, StatsActv::class.java))
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainContent()
    }

}

