package com.restful.btg.pactual.technical.test.exception

class PedidoNaoEncontradoException(codigoPedido: Long) :
    RuntimeException("Pedido não encontrado: $codigoPedido")