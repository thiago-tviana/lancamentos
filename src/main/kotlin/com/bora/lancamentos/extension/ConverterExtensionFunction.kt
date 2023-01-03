package com.bora.lancamentos.extension

import com.bora.lancamentos.controller.dto.request.CreateCategoriaRequest
import com.bora.lancamentos.controller.dto.request.UpdateCategoriaRequest
import com.bora.lancamentos.model.Categoria

fun CreateCategoriaRequest.toCategoria(): Categoria {
    return Categoria(nome = this.nome)
}

fun UpdateCategoriaRequest.toCategoria(id: Long): Categoria {
    return Categoria(nome = this.nome, id = id)
}