package com.gerali.app.ui.tickets

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gerali.app.data.model.Ticket
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.GeraliCard
import com.gerali.app.ui.theme.TextSecondary

@Composable
fun TicketListScreen(
    tickets: List<Ticket>,
    onSelectTicket: (Ticket) -> Unit,
    onGenerateTicket: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Meus Tickets",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Controle de uso e validade",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )

        Spacer(Modifier.height(16.dp))

        tickets.forEach { ticket ->
            GeraliCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(ticket.codigoTicket, style = MaterialTheme.typography.titleMedium)
                        Text("Validade: ${ticket.dataValidade}", color = TextSecondary)
                    }
                    Text("R$ ${ticket.valorAutorizado}")
                }
                Spacer(Modifier.height(12.dp))
                GeraliButton(
                    text = "Ver detalhes",
                    onClick = { onSelectTicket(ticket) }
                )
            }
            Spacer(Modifier.height(12.dp))
        }

        GeraliButton(text = "Gerar Ticket", onClick = onGenerateTicket)
    }
}
