package com.example.examen1.screen

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.examen1.R
import com.example.examen1.component.DeforestAreaCard
import com.example.examen1.database.entities.User
import com.example.examen1.database.model.Worker
import com.example.examen1.dialog.DeforestedAreaCreate
import com.example.examen1.dialog.DeforestedAreaDelete
import com.example.examen1.dialog.DeforestedAreaEdit
import com.example.examen1.model.DeforestedArea
import com.example.examen1.navigation.AppScreen
import com.example.examen1.ui.theme.Examen1Theme

data class DialogStates(
    var showAddDialog: MutableState<Boolean>,
    var showEditDialog: MutableState<Boolean>,
    var showDeleteDialog: MutableState<Boolean>,
    var deforestedArea: MutableState<DeforestedArea>
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun DeforestedAreaListScreen(navController: NavController, user_id: Int?, worker : Worker){
    val scope = rememberCoroutineScope()
    val listOfusers = remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        val users = worker.getAll()
        listOfusers.clear()
        users.forEach {
            Log.d(TAG, it.toString())
            listOfusers.add(it.toString())
        }

    }
    val dialogStates = DialogStates(
        showAddDialog = remember { mutableStateOf(false) },
        showEditDialog = remember { mutableStateOf(false) },
        showDeleteDialog = remember { mutableStateOf(false) },
        deforestedArea = remember {
            mutableStateOf(DeforestedArea(
                "", "",
                "", "", 0.0,
                "", "", "",
            ))
        }
    )

    val deforestedAreaList = remember {
        mutableStateOf(
            listOf(
                DeforestedArea(
                nombre = "Zona 01",
                fechaDeteccion = "01/05/23",
                latitud = "82128772",
                longitud = "29292928",
                tamanioZD = 20000.0,
                CausaZD = "Agregar texto",
                consecuenciaZD = "Otro texto",
                img = R.drawable.ic_launcher_foreground.toString()
                )
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Zonas Deforestadas , Usuarios Reg:" + listOfusers.size.toString()) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = { dialogStates.showAddDialog.value = true },
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {
        DeforestedAreaListContent(navController, dialogStates, deforestedAreaList, user_id)

        DeforestedAreaCreate(
            isVisible = dialogStates.showAddDialog,
            onCreated = {
                println("CREATE---notify")
            }
        )
        DeforestedAreaDelete(
            isVisible = dialogStates.showDeleteDialog,
            deforestedArea = dialogStates.deforestedArea,
            onDeleted = {
                println("DELETE---notify")
                deforestedAreaList.value = listOf()
            }
        )
        DeforestedAreaEdit(
            isVisible = dialogStates.showEditDialog,
            deforestedArea = dialogStates.deforestedArea,
            onUpdated = {
                println("EDIT---notify")
            }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun DeforestedAreaListContent(
    navController: NavController,
    dialogStates: DialogStates,
    deforestedAreaList: MutableState<List<DeforestedArea>>,
    user_id: Int?
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 40.dp, end = 16.dp, start = 16.dp, top = 16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(deforestedAreaList.value.size){ index ->
                    DeforestAreaCard(
                        deforestedArea = deforestedAreaList.value.get(index),
                        detail = {
                            val id = 1 //deforestedAreaData.get(index).id
                            navController.navigate(route = AppScreen.DeforestedAreaDetailScreen.route + "/$user_id/$id")
                        },
                        edit = {
                            dialogStates.showEditDialog.value = true
                            dialogStates.deforestedArea.value = deforestedAreaList.value.get(index).copy()
                        },
                        delete = {
                            dialogStates.showDeleteDialog.value = true
                            dialogStates.deforestedArea.value = deforestedAreaList.value.get(index).copy()
                        }
                    )
                }
            }
        }
    }
}

/*@ExperimentalMaterial3Api
@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewList() {
    Examen1Theme {
        val navController = rememberNavController()
        DeforestedAreaListScreen(navController, 1)
    }
}*/
