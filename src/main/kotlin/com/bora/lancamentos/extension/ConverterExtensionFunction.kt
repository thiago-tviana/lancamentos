package com.bora.lancamentos.extension

import com.bora.lancamentos.controller.dto.request.CreateCategoriaRequest
import com.bora.lancamentos.controller.dto.request.LancamentoCreateRequest
import com.bora.lancamentos.controller.dto.request.UpdateCategoriaRequest
import com.bora.lancamentos.model.Categoria
import com.bora.lancamentos.model.Lancamento
import com.bora.lancamentos.model.Pessoa

fun CreateCategoriaRequest.toCategoria(): Categoria {
    return Categoria(nome = this.nome)
}

fun UpdateCategoriaRequest.toCategoria(id: Long): Categoria {
    return Categoria(nome = this.nome, id = id)
}

fun LancamentoCreateRequest.toLancamento(): Lancamento {
    var pessoa = Pessoa(this.pessoaId, null, null, null)
    var categoria = Categoria(this.categoriaId, null)
    return Lancamento(
        id = null,
        descricao = this.descricao,
        dataVencimento = this.dataVencimento,
        dataPagamento = null,
        valor = this.valor,
        observacao = this.observacao,
        tipo = this.tipo,
        categoria = categoria,
        pessoa = pessoa
    )
}