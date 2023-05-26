package com.example.examen1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.examen1.database.model.MyAppDatabase
import com.example.examen1.database.model.Worker
import com.example.examen1.navigation.AppNavigation
import com.example.examen1.screen.LoginContent
import com.example.examen1.screen.LoginScreen
import com.example.examen1.ui.theme.Examen1Theme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Examen1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val repository = Worker(MyAppDatabase.getInstance(LocalContext.current.applicationContext))
                    AppNavigation(repository)
                }
            }
        }
    }
}

/*@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Examen1Theme {
        AppNavigation()
    }
}*/