package com.example.provaconcess.screens

import ExpandableCard
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.provaconcess.R
import com.example.provaconcess.model.Car
import com.example.provaconcess.ui.theme.Shapes

val addCar = MutableLiveData(Car())

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FormFields() {
   // val addCar = MutableLiveData(Car())
    val types = stringArrayResource(id = R.array.types)
    val carModel = remember { mutableStateOf("") }
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
        OutlinedTextField(value = carModel.value,
            onValueChange = { carModel.value = it
                            addCar.value = addCar.value?.copy(model = it)},
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

        Button(onClick = { onAddTapped() }) {
            Text(text = stringResource(id = R.string.submit_btn))
        }
    }

    // LISTA
//    ExpandableCard(
//        title = carModel.value,
//        description = "10000" +
//                "sedan",
//    )
}

fun onAddTapped() {
    val carro = addCar.value?: return
    println(carro)
}


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    //val addCar = MutableLiveData(Car())
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        FormFields()
        ExpandableCard(
            title = "Fusca 72",
            description = "10 000" +
                    "Hatch" +
                    "Available"
        )
    }
}


