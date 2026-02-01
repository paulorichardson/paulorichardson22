package com.gerali.app.data.repository

import com.gerali.app.data.api.ApiService
import com.gerali.app.data.api.LoginRequest
import com.gerali.app.data.model.LoginResponse

class AuthRepository(private val apiService: ApiService) {
    suspend fun login(cpf: String, senha: String): LoginResponse {
        return apiService.login(LoginRequest(cpf = cpf, senha = senha))
    }
}
