package com.bora.lancamentos.exception

enum class Errors(val code: String, val message: String) {

    CATEGORIA_NAO_ENCONTRADA("CAT-1001", "Categoria de id %s não existe")
}