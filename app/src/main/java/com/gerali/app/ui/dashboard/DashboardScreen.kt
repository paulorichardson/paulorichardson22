package com.gerali.app.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.GeraliCard
import com.gerali.app.ui.theme.GeraliBlue
import com.gerali.app.ui.theme.GeraliGreen
import com.gerali.app.ui.theme.TextSecondary

@Composable
fun DashboardScreen(
    onViewTickets: () -> Unit,
    onManageServidores: () -> Unit,
    onOpenScanner: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Dashboard GERALI",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Resumo do dia",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GeraliCard(
                modifier = Modifier.weight(1f),
                gradient = Brush.verticalGradient(listOf(GeraliBlue, GeraliBlue.copy(alpha = 0.8f)))
            ) {
                Text("150", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Text("Servidores", color = Color.White.copy(alpha = 0.8f))
            }
            GeraliCard(
                modifier = Modifier.weight(1f),
                gradient = Brush.verticalGradient(listOf(GeraliGreen, GeraliGreen.copy(alpha = 0.8f)))
            ) {
                Text("45", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Text("Tickets hoje", color = Color.White.copy(alpha = 0.8f))
            }
        }

        Spacer(Modifier.height(16.dp))

        GeraliCard(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Consumo mensal",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text("R$ 45.000,00", style = MaterialTheme.typography.headlineMedium)
        }

        Spacer(Modifier.height(24.dp))

        GeraliButton(text = "Ver Tickets", onClick = onViewTickets)
        Spacer(Modifier.height(12.dp))
        GeraliButton(text = "Gerenciar Servidores", onClick = onManageServidores)
        Spacer(Modifier.height(12.dp))
        GeraliButton(text = "Abrir Scanner", onClick = onOpenScanner)
    }
}
