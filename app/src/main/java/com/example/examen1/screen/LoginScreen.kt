package com.example.examen1.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.examen1.database.entities.User
import com.example.examen1.database.model.Worker
import com.example.examen1.navigation.AppNavigation
import com.example.examen1.navigation.AppScreen
import com.example.examen1.ui.theme.Examen1Theme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun LoginScreen(navController: NavController,worker: Worker){
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Inicio de session") },
            )
        }
    ) {
        LoginContent(navController,worker)
    }
}

@ExperimentalMaterial3Api
@Composable
fun LoginContent(navController: NavController,worker: Worker){
    val scope = rememberCoroutineScope()
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(top = 60.dp, start = 16.dp, bottom = 80.dp, end = 16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Nombre de usuario"
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Contraseña"
        )
        PasswordField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(route = AppScreen.DeforestedAreaListScreen.route + "/1")
            val user = User(0,username, password)
            scope.launch {
                worker.insert(user)
            }}) {
            Text(text = "Iniciar sesión")
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Outlined.Lock else Icons.Default.Lock,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        },
        modifier = modifier
    )
}

/*@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreviewLogin() {
    Examen1Theme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}*/

