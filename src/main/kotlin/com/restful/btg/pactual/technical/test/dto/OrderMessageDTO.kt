package com.restful.btg.pactual.technical.test.dto

import java.math.BigDecimal

data class OrderMessageDTO(
    val codigoPedido: Long,
    val codigoCliente: Long,
    val itens: List<ItemDTO>
) {
    data class ItemDTO(
        val produto: String,
        val quantidade: Int,
        val preco: BigDecimal
    )
}