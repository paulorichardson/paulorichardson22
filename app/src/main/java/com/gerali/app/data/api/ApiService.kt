package com.gerali.app.data.api

import com.gerali.app.data.model.LoginResponse
import com.gerali.app.data.model.TicketResponse
import com.gerali.app.data.model.ValidationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

data class LoginRequest(
    val cpf: String,
    val senha: String
)

data class TicketRequest(
    val servidor_id: String,
    val tipo: String
)

data class ValidationRequest(
    val codigo: String,
    val credenciado_id: String
)

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("tickets/gerar")
    suspend fun gerarTicket(
        @Header("Authorization") token: String,
        @Body request: TicketRequest
    ): TicketResponse

    @POST("tickets/validar")
    suspend fun validarTicket(
        @Header("Authorization") token: String,
        @Body request: ValidationRequest
    ): ValidationResponse

    @GET("tickets/servidor/{id}")
    suspend fun listarTickets(
        @Header("Authorization") token: String,
        @Path("id") servidorId: String
    ): List<TicketResponse>

    @GET("relatorios/dashboard")
    suspend fun dashboard(
        @Header("Authorization") token: String
    ): Map<String, Any>
}
