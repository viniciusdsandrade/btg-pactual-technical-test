package com.restful.btg.pactual.technical.test.service

interface OrderService  {
    fun processarPedido(dto: com.restful.btg.pactual.technical.test.dto.OrderMessageDTO)
    fun consultarValorTotalPedido(codigoPedido: Long): java.math.BigDecimal
    fun contarPedidosPorCliente(codigoCliente: Long): Long
    fun listarPedidosPorCliente(codigoCliente: Long): List<com.restful.btg.pactual.technical.test.entity.OrderDocument>
}
