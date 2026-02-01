package com.gerali.app.data.model

import com.google.gson.annotations.SerializedName

data class Ticket(
    val id: String,
    @SerializedName("codigo_ticket") val codigoTicket: String,
    @SerializedName("servidor_id") val servidorId: String,
    @SerializedName("servidor_nome") val servidorNome: String?,
    @SerializedName("cpf_mascarado") val cpfMascarado: String?,
    @SerializedName("valor_autorizado") val valorAutorizado: Double,
    val tipo: TipoTicket,
    @SerializedName("data_geracao") val dataGeracao: String,
    @SerializedName("data_validade") val dataValidade: String,
    val status: StatusTicket,
    val usado: Boolean,
    @SerializedName("data_uso") val dataUso: String?,
    @SerializedName("credenciado_nome") val credenciadoNome: String?
)

enum class TipoTicket {
    @SerializedName("diario") DIARIO,
    @SerializedName("evento") EVENTO,
    @SerializedName("manual") MANUAL
}

enum class StatusTicket {
    @SerializedName("ativo") ATIVO,
    @SerializedName("expirado") EXPIRADO,
    @SerializedName("usado") USADO,
    @SerializedName("cancelado") CANCELADO
}
