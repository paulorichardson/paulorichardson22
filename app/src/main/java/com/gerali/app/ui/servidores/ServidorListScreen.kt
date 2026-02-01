package com.gerali.app.ui.servidores

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gerali.app.data.model.Servidor
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.GeraliCard
import com.gerali.app.ui.theme.TextSecondary

@Composable
fun ServidorListScreen(
    servidores: List<Servidor>,
    onAddServidor: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Servidores", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text("Cadastro de beneficiários", color = TextSecondary)

        Spacer(Modifier.height(16.dp))

        servidores.forEach { servidor ->
            GeraliCard(modifier = Modifier.fillMaxWidth()) {
                Text(servidor.nome, style = MaterialTheme.typography.titleMedium)
                Text("CPF: ${servidor.cpf}")
                Text("Secretaria: ${servidor.secretaria}")
            }
            Spacer(Modifier.height(12.dp))
        }

        GeraliButton(text = "Cadastrar Servidor", onClick = onAddServidor)
    }
}
