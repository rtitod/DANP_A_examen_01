package com.example.examen1.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.examen1.R
import com.example.examen1.model.DeforestedArea
import com.example.examen1.ui.theme.Examen1Theme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun DeforestedAreaDetailScreen(navController: NavController, user_id: Int?, deforested_area_id: Int?){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detalle de Zonas Deforestadas") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                }
            )
        }
    ) {
        DeforestedAreaDetailContent(navController, user_id, deforested_area_id)
    }
}

@ExperimentalMaterial3Api
@Composable
fun DeforestedAreaDetailContent(navController: NavController, user_id: Int?, deforested_area_id: Int?){

    var deforestedArea: DeforestedArea = DeforestedArea(
        "Zona 01", "01/05/23",
        "82128772", "29292928", 20000.0,
        "Agregar texto", "Otro texto", R.drawable.ic_launcher_foreground.toString(),
    )

    Column( modifier = Modifier.padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 16.dp) ) {deforested_area_id
        Card(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp, bottom = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = deforestedArea.img.toInt()),
                    contentDescription = "default.png",
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column(modifier = Modifier.padding(top = 60.dp)) {
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Nombre: ${deforestedArea.nombre}")
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Fecha de Detección: ${deforestedArea.fechaDeteccion}")
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Latitud: ${deforestedArea.latitud}")
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Longitud: ${deforestedArea.longitud}")
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Tamaño Zona Deforestada: ${deforestedArea.tamanioZD}")
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Causa Zona Deforestada: ${deforestedArea.CausaZD}")
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Consecuencia Zona Deforestada: ${deforestedArea.consecuenciaZD}")
                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewDetail() {
    Examen1Theme {
        val navController = rememberNavController()
        DeforestedAreaDetailContent(navController, 1, 1)
    }
}