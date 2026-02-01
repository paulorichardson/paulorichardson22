package com.gerali.app.data.model

import com.google.gson.annotations.SerializedName

data class Servidor(
    val id: String,
    val nome: String,
    val cpf: String,
    val matricula: String,
    val secretaria: String,
    @SerializedName("limite_mensal") val limiteMensal: Double
)
