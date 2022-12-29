package com.bora.lancamentos.model

import javax.persistence.*

@Entity
@Table(name = "categoria")
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "nome")
    var nome: String
)