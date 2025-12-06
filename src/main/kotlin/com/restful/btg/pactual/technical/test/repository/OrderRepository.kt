package com.restful.btg.pactual.technical.test.repository

import com.restful.btg.pactual.technical.test.entity.OrderDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<OrderDocument, String> {

    fun findByCodigoPedido(codigoPedido: Long): OrderDocument?

    fun countByCodigoCliente(codigoCliente: Long): Long

    fun findByCodigoCliente(codigoCliente: Long): List<OrderDocument>
}
