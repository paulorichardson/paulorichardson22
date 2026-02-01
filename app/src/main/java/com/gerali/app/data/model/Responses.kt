package com.gerali.app.data.model

data class LoginResponse(
    val sucesso: Boolean,
    val token: String,
    val usuario: Usuario,
    val erro: String?
)

data class TicketResponse(
    val sucesso: Boolean,
    val ticket: Ticket?,
    val erro: String?
)

data class ValidationResponse(
    val sucesso: Boolean,
    val mensagem: String,
    val servidorNome: String?,
    val servidorCpf: String?,
    val valor: Double?,
    val dataHora: String?
)
