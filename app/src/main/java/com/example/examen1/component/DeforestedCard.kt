package com.example.examen1.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examen1.model.DeforestedArea

@Composable
fun DeforestAreaCard(
    deforestedArea: DeforestedArea,
    detail: () -> Unit,
    edit: () -> Unit,
    delete: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable { }
            .fillMaxWidth()
            .clickable(onClick = detail),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(all = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = deforestedArea.img.toInt()),
                contentDescription = "default.png",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(160.dp)
            ) {
                Text(text = "Nombre: "+ deforestedArea.nombre)
                Text(text = "Fecha detección: "+ deforestedArea.fechaDeteccion)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = edit) {
                Icon(Icons.Filled.Edit, contentDescription = "Editar")
            }
            IconButton(onClick = delete) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
            }
        }
    }
}