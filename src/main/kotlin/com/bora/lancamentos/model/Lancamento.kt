package com.bora.lancamentos.model

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "Lancamento")
data class Lancamento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "descricao")
    var descricao: String,

    @Column(name = "data_vencimento")
    var dataVencimento: LocalDate,

    @Column(name = "data_pagamento")
    var dataPagamento: LocalDate?,

    var valor: BigDecimal,
    var observacao: String?,

    @Enumerated(EnumType.STRING)
    var tipo: TipoLancamento,

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    var categoria: Categoria,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    var pessoa: Pessoa

)

enum class TipoLancamento {
    RECEITA,
    DESPESA
}
