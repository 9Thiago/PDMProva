package com.example.provaconcess.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.provaconcess.R
import com.example.provaconcess.navigation.Screen


@Composable
fun SettingsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("VENDIDOS",fontSize = 20.sp,
            color = Color.Red)
        Text(" NÃO VENDIDOS",fontSize = 20.sp,
            color = Color.Green)
        CanvasShapes(
            points = listOf(60f,40f),
            colorsList = listOf(Color.Green,Color.Red)
        )
    }
}

@Composable
fun CanvasShapes(points:List<Float>,colorsList:List<Color>) {
    val totalSum = points.sum()
    val percentageWeight = points.map { it*100/totalSum }
    val percentageAngle = percentageWeight.map { it*360/100 }

    Canvas(modifier = Modifier
        .fillMaxSize(fraction = 0.5F)
        .background(Color.White)){
        var startAngle = 100f
        drawArc(
            color = colorsList[0],
            startAngle = startAngle,
            sweepAngle = percentageAngle[0],
            useCenter = true,
            //size = Size(size.width.minus(200),size.height.minus(200))
            size = Size(size.width,size.height)
        )
        startAngle+=percentageAngle[0]
        drawArc(
            color = colorsList[1],
            startAngle = startAngle,
            sweepAngle = percentageAngle[0],
            useCenter = true,
            size = Size(size.width,size.height)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController())

}