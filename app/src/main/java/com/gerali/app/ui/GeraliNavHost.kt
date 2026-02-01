package com.gerali.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gerali.app.data.model.StatusTicket
import com.gerali.app.data.model.Ticket
import com.gerali.app.data.model.TipoTicket
import com.gerali.app.data.model.Servidor
import com.gerali.app.ui.dashboard.DashboardScreen
import com.gerali.app.ui.login.LoginScreen
import com.gerali.app.ui.tickets.TicketDetailPreviewScreen
import com.gerali.app.ui.tickets.TicketListScreen
import com.gerali.app.ui.tickets.GenerateTicketScreen
import com.gerali.app.ui.scanner.ScannerScreen
import com.gerali.app.ui.servidores.ServidorFormScreen
import com.gerali.app.ui.servidores.ServidorListScreen

@Composable
fun GeraliNavHost() {
    val navController = rememberNavController()
    val sampleTickets = listOf(
        Ticket(
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
        ),
        Ticket(
            id = "2",
            codigoTicket = "TKT-2026-54321-XYZ",
            servidorId = "srv-2",
            servidorNome = "Maria Souza",
            cpfMascarado = "111.111.111-11",
            valorAutorizado = 25.0,
            tipo = TipoTicket.EVENTO,
            dataGeracao = "2026-02-03",
            dataValidade = "2026-02-10",
            status = StatusTicket.ATIVO,
            usado = true,
            dataUso = "2026-02-04",
            credenciadoNome = "Restaurante Central"
        )
    )
    val sampleServidores = listOf(
        Servidor(
            id = "srv-1",
            nome = "João Santos",
            cpf = "222.222.222-22",
            matricula = "M12345",
            secretaria = "Saúde",
            limiteMensal = 600.0
        ),
        Servidor(
            id = "srv-2",
            nome = "Maria Souza",
            cpf = "111.111.111-11",
            matricula = "M54321",
            secretaria = "Educação",
            limiteMensal = 500.0
        )
    )

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("dashboard") },
                onGoToScanner = { navController.navigate("scanner") }
            )
        }
        composable("dashboard") {
            DashboardScreen(
                onViewTickets = { navController.navigate("tickets") },
                onManageServidores = { navController.navigate("servidores") },
                onOpenScanner = { navController.navigate("scanner") }
            )
        }
        composable("tickets") {
            TicketListScreen(
                tickets = sampleTickets,
                onSelectTicket = { navController.navigate("ticket") },
                onGenerateTicket = { navController.navigate("generate-ticket") }
            )
        }
        composable("generate-ticket") {
            GenerateTicketScreen(onGenerate = { navController.navigate("ticket") })
        }
        composable("ticket") {
            TicketDetailPreviewScreen(onBack = { navController.popBackStack() })
        }
        composable("scanner") {
            ScannerScreen(onBack = { navController.popBackStack() })
        }
        composable("servidores") {
            ServidorListScreen(
                servidores = sampleServidores,
                onAddServidor = { navController.navigate("servidor-form") }
            )
        }
        composable("servidor-form") {
            ServidorFormScreen(onSave = { navController.popBackStack() })
        }
    }
}
