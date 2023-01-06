package com.bora.lancamentos.model

import javax.persistence.*

@Entity
@Table(name = "pessoa")
data class Pessoa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "nome")
    var nome: String?,

    @Column(name = "ativa")
    var ativa: Boolean? = true,

    @Column(name = "endereco")
    @Embedded
    var endereco: Endereco?
)
