package com.gerali.app.ui.tickets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.GeraliTextField

@Composable
fun GenerateTicketScreen(onGenerate: () -> Unit) {
    var servidor by remember { mutableStateOf("") }
    var validade by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Gerar Ticket", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))

        GeraliTextField(
            value = servidor,
            onValueChange = { servidor = it },
            label = "Servidor",
            placeholder = "Nome ou matrícula"
        )

        Spacer(Modifier.height(12.dp))

        GeraliTextField(
            value = validade,
            onValueChange = { validade = it },
            label = "Validade",
            placeholder = "01/02 até 28/02"
        )

        Spacer(Modifier.height(24.dp))

        GeraliButton(text = "Gerar QR Code", onClick = onGenerate)
    }
}
