package com.example.examen1.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.examen1.model.DeforestedArea

@ExperimentalMaterial3Api
@Composable
fun DeforestedAreaDelete(isVisible: MutableState<Boolean>, deforestedArea: MutableState<DeforestedArea>, onDeleted: () -> Unit) {
    if (isVisible.value)
        AlertDialog(
            onDismissRequest = { isVisible.value = false },
            confirmButton = {
                TextButton(onClick = {
                    println("DELETE---Action")
                    var status = true
                    if(status)
                        onDeleted()
                    else
                        println("error")
                    isVisible.value = false
                }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { isVisible.value = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Eliminar") },
            text = { Text(text = "¿Esta seguro de eliminar esta zona deforestada?") }
        )
}