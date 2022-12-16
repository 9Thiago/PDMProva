package com.example.provaconcess

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
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
        ) { NavigationSetup(navController = navController, FormFields()) }
    }

    @Composable
    fun FormFields() {
        val carModelState = remember { mutableStateOf("") }
        var vExpanded by remember { mutableStateOf(false) }
        var carType by remember { mutableStateOf("") }
        var carPrice by remember { mutableStateOf("") }
        val cTypes = listOf("Hatch", "Truck", "MotorBike", "Sedan", "PickUp", "Van", "SUV")

        val icon = if (vExpanded) Icons.Filled.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
            //.background(color = Color.LightGray)
        )
        {
            OutlinedTextField(value = carModelState.value,
                onValueChange = { carModelState.value = it },
                label = { Text(text = stringResource(id = R.string.model_hint)) }
            )
            Box() {
                OutlinedTextField(
                    value = carType,
                    onValueChange = { carType = it },
                    readOnly = true,
                    label = { Text("Type") },
                    trailingIcon = {
                        Icon(icon, "contentDescription",
                            Modifier.clickable { vExpanded = !vExpanded })
                    }
                )
                DropdownMenu(
                    expanded = vExpanded,
                    onDismissRequest = { vExpanded = false },
                ) {
                    cTypes.forEach { label ->
                        DropdownMenuItem(onClick = {
                            carType = label
                            vExpanded = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }



            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.submit_btn))
            }
        }

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

