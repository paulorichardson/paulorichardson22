package com.gerali.app.ui.servidores

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.GeraliTextField

@Composable
fun ServidorFormScreen(onSave: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var secretaria by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Novo Servidor", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))

        GeraliTextField(value = nome, onValueChange = { nome = it }, label = "Nome")
        Spacer(Modifier.height(12.dp))
        GeraliTextField(value = cpf, onValueChange = { cpf = it }, label = "CPF")
        Spacer(Modifier.height(12.dp))
        GeraliTextField(value = matricula, onValueChange = { matricula = it }, label = "Matrícula")
        Spacer(Modifier.height(12.dp))
        GeraliTextField(value = secretaria, onValueChange = { secretaria = it }, label = "Secretaria")

        Spacer(Modifier.height(24.dp))

        GeraliButton(text = "Salvar", onClick = onSave)
    }
}
