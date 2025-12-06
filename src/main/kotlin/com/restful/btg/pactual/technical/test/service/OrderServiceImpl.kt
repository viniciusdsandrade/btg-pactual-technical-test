package com.restful.btg.pactual.technical.test.service

import com.restful.btg.pactual.technical.test.dto.OrderMessageDTO
import com.restful.btg.pactual.technical.test.entity.OrderDocument
import com.restful.btg.pactual.technical.test.entity.OrderItem
import com.restful.btg.pactual.technical.test.exception.PedidoNaoEncontradoException
import com.restful.btg.pactual.technical.test.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.Instant

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {

    @Transactional
    override fun processarPedido(dto: OrderMessageDTO) {
        if (orderRepository.findByCodigoPedido(dto.codigoPedido) != null) return

        val itens = dto.itens.map { itemDto ->
            OrderItem(
                produto = itemDto.produto,
                quantidade = itemDto.quantidade,
                preco = itemDto.preco
            )
        }

        val total = itens.fold(BigDecimal.ZERO) { acc, item ->
            acc + item.preco.multiply(BigDecimal(item.quantidade))
        }

        val order = OrderDocument(
            codigoPedido = dto.codigoPedido,
            codigoCliente = dto.codigoCliente,
            itens = itens,
            valorTotal = total,
            criadoEm = Instant.now()
        )

        orderRepository.save(order)
    }

    override fun consultarValorTotalPedido(codigoPedido: Long): BigDecimal =
        orderRepository.findByCodigoPedido(codigoPedido)?.valorTotal
            ?: throw PedidoNaoEncontradoException(codigoPedido)

    override fun contarPedidosPorCliente(codigoCliente: Long): Long =
        orderRepository.countByCodigoCliente(codigoCliente)

    @Override
    override fun listarPedidosPorCliente(codigoCliente: Long): List<OrderDocument> =
        orderRepository.findByCodigoCliente(codigoCliente)
}