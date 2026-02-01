package com.gerali.app.data.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    val id: String,
    val cpf: String,
    val nome: String,
    val email: String?,
    val perfil: Perfil,
    @SerializedName("municipio_nome") val municipioNome: String?,
    @SerializedName("servidor_id") val servidorId: String? = null,
    @SerializedName("credenciado_id") val credenciadoId: String? = null
)

enum class Perfil {
    @SerializedName("admin_municipal") ADMIN_MUNICIPAL,
    @SerializedName("servidor") SERVIDOR,
    @SerializedName("credenciado") CREDENCIADO,
    @SerializedName("fiscal") FISCAL
}
