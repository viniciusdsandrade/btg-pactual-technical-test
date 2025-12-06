package com.restful.btg.pactual.technical.test.entity


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.Instant

@Document("orders")
data class OrderDocument(
    @Id val id: String? = null,
    val codigoPedido: Long,
    val codigoCliente: Long,
    val itens: List<OrderItem>,
    val valorTotal: BigDecimal,
    val criadoEm: Instant
)

data class OrderItem(
    val produto: String,
    val quantidade: Int,
    val preco: BigDecimal
)
