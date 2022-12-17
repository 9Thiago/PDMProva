package com.example.provaconcess.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.provaconcess.R

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

        OutlinedTextField(
            value = carPrice,
            onValueChange = {
                carPrice = if (it.startsWith("0")) {
                    ""
                } else {
                    it
                }
            },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.submit_btn))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        FormFields()
    }
}

