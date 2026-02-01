package com.gerali.app.ui.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gerali.app.R
import com.gerali.app.data.model.StatusTicket
import com.gerali.app.data.model.Ticket
import com.gerali.app.data.model.TipoTicket
import com.gerali.app.ui.components.ButtonVariant
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.QRCodeView
import com.gerali.app.ui.theme.GeraliBlue
import com.gerali.app.ui.theme.GrayBackground
import com.gerali.app.ui.theme.TextPrimary
import com.gerali.app.ui.theme.TextSecondary

@Composable
fun TicketDetailPreviewScreen(onBack: () -> Unit) {
    val ticket = Ticket(
        id = "1",
        codigoTicket = "TKT-2026-12345-ABC",
        servidorId = "srv-1",
        servidorNome = "João Santos",
        cpfMascarado = "222.222.222-22",
        valorAutorizado = 30.0,
        tipo = TipoTicket.DIARIO,
        dataGeracao = "2026-02-01",
        dataValidade = "2026-02-28",
        status = StatusTicket.ATIVO,
        usado = false,
        dataUso = null,
        credenciadoNome = null
    )

    TicketDetailScreen(ticket = ticket, onBack = onBack)
}

@Composable
fun TicketDetailScreen(ticket: Ticket, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(GeraliBlue, GeraliBlue.copy(alpha = 0.8f))
                        )
                    )
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                androidx.compose.foundation.Image(
                    painter = painterResource(R.drawable.ic_gerali_icon),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Text(
                    "GERALI",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Gestão de Alimentação Inteligente",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.8f)
                )

                Spacer(Modifier.height(24.dp))

                Card(
                    modifier = Modifier.size(280.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        QRCodeView(
                            content = ticket.codigoTicket,
                            size = 250.dp
                        )
                    }
                }

                Spacer(Modifier.height(24.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        "💳 TICKET DE ALIMENTAÇÃO",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = GeraliBlue
                    )

                    Spacer(Modifier.height(16.dp))

                    InfoRow("👤 Beneficiário", ticket.servidorNome ?: "")
                    InfoRow("🆔 CPF", ticket.cpfMascarado ?: "")
                    InfoRow("📅 Válido até", ticket.dataValidade)
                    InfoRow("💰 Valor", "R$ ${ticket.valorAutorizado}")

                    Spacer(Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                if (ticket.usado) Color.Red.copy(alpha = 0.1f)
                                else Color.Green.copy(alpha = 0.1f),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            if (ticket.usado) "✓" else "⚠️",
                            fontSize = 20.sp
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            if (ticket.usado) "Ticket já utilizado" else "Uso único - não reutilizável",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GeraliButton(
                text = "💾 Salvar",
                onClick = onBack,
                modifier = Modifier.weight(1f),
                variant = ButtonVariant.Outline
            )

            GeraliButton(
                text = "📤 Compartilhar",
                onClick = onBack,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
        Text(
            value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = TextPrimary
        )
    }
}
