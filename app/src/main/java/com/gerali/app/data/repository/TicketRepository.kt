package com.gerali.app.data.repository

import com.gerali.app.data.api.ApiService
import com.gerali.app.data.api.TicketRequest
import com.gerali.app.data.api.ValidationRequest
import com.gerali.app.data.model.TicketResponse
import com.gerali.app.data.model.ValidationResponse

class TicketRepository(private val apiService: ApiService) {
    suspend fun gerarTicket(token: String, servidorId: String, tipo: String): TicketResponse {
        return apiService.gerarTicket(
            token = token,
            request = TicketRequest(servidor_id = servidorId, tipo = tipo)
        )
    }

    suspend fun validarTicket(token: String, codigo: String, credenciadoId: String): ValidationResponse {
        return apiService.validarTicket(
            token = token,
            request = ValidationRequest(codigo = codigo, credenciado_id = credenciadoId)
        )
    }
}
