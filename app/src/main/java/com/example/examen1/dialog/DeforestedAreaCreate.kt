package com.example.examen1.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.examen1.model.DeforestedArea

@ExperimentalMaterial3Api
@Composable
fun DeforestedAreaCreate(isVisible: MutableState<Boolean>, onCreated: () -> Unit) {
    if (isVisible.value) {
        var tfnombre by remember { mutableStateOf("") }
        var tffechaDeteccion by remember { mutableStateOf("") }
        var tflatitud by remember { mutableStateOf("") }
        var tflongitud by remember { mutableStateOf("") }
        var tftamanioZD by remember { mutableStateOf("") }
        var tfImagen by remember { mutableStateOf("") } //ver como imprimir una imagen
        var tfCausasZD by remember { mutableStateOf("") }
        var tfConsecuenciasZD by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = { isVisible.value = false },
            confirmButton = {
                TextButton(onClick = {
                    println("CREATE---Action")
                    var status = true
                    if(status)
                        onCreated()
                    isVisible.value = false
                }) {
                    Text(text = "Registrar")
                }
            },
            dismissButton = {
                TextButton(onClick = { isVisible.value = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Registrar") },
            text = {
                Column() {
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp), value = tfnombre,
                        onValueChange = { tfnombre = it },
                        placeholder = { Text(text = "Nombre") }
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tffechaDeteccion,
                        onValueChange = { tffechaDeteccion = it },
                        placeholder = { Text(text = "Fecha detección") }
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tflatitud,
                        onValueChange = { tflatitud = it },
                        placeholder = { Text(text = "Latitud") }
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tflongitud,
                        onValueChange = { tflongitud = it },
                        placeholder = { Text(text = "Longitud") }
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tftamanioZD,
                        onValueChange = { tftamanioZD = it },
                        placeholder = { Text(text = "Tamaño de Zona Deforestada") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tfCausasZD,
                        onValueChange = { tfCausasZD = it },
                        placeholder = { Text(text = "Causa de Zona Deforestada") }
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tfConsecuenciasZD,
                        onValueChange = { tfConsecuenciasZD = it },
                        placeholder = { Text(text = "Consecuencia de Zona Deforestada") }
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 8.dp),
                        value = tfImagen,
                        onValueChange = { tfImagen= it },
                        placeholder = { Text(text = "URL de Imagen") }
                    )
                }
            }
        )
    }
}