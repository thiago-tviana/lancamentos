package com.bora.lancamentos.controller.dto.request

import com.bora.lancamentos.model.TipoLancamento
import java.math.BigDecimal
import java.time.LocalDate

data class LancamentoCreateRequest(
    var descricao: String,
    var dataVencimento: LocalDate,
    var valor: BigDecimal,
    var observacao: String?,
    var tipo: TipoLancamento,
    var categoriaId: Long,
    var pessoaId: Long,
)
