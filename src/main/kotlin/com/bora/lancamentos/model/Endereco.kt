package com.bora.lancamentos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Embeddable

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
data class Endereco(

    var logradouro: String,
    var bairro: String,
    var localidade: String,
    var uf: String
)
