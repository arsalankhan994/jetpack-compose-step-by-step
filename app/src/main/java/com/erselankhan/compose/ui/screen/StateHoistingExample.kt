package com.erselankhan.compose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WithoutStateHoistingMethodExample() {
    HelloContentWithoutStateHoisting()
}


@Composable
fun WithStateHoistingMethodExample() {
    val name = remember { mutableStateOf("") }
    HelloContentWithStateHoisting(name = name.value, onNameChange = { name.value = it })
}

@Composable
fun HelloContentWithStateHoisting(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}

@Composable
fun HelloContentWithoutStateHoisting() {
    val name = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, ${name.value}",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text("Name") }
        )
    }
}