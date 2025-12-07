package com.restful.btg.pactual.technical.test.entity

import java.math.BigDecimal

data class OrderItem(
    val produto: String,
    val quantidade: Int,
    val preco: BigDecimal
)
