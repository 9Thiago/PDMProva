package com.example.provaconcess

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.rememberNavController
import com.example.provaconcess.navigation.BottomNavigationBar
import com.example.provaconcess.navigation.NavigationSetup
import com.example.provaconcess.ui.theme.ProvaConcessTheme
import java.net.ContentHandler

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
//                    navigationIcon = {
//                        IconButton(onClick = { showNextPage() }) {
//                            Icon(
//                                imageVector = Icons.Filled.ArrowForward,
//                                contentDescription = "Next",
//                            )
//                        }
//                    },
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
        ) {NavigationSetup(navController = navController)}
    }

    private @Composable
    fun FormFields() {
        TODO("Not yet implemented")
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

