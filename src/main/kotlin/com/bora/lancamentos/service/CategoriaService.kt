package com.bora.lancamentos.service

import com.bora.lancamentos.exception.Errors
import com.bora.lancamentos.exception.NotFoundException
import com.bora.lancamentos.model.Categoria
import com.bora.lancamentos.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    val categoriaRepository: CategoriaRepository
) {

    fun listar(nome: String?): List<Categoria> {
        nome?.let {
            return categoriaRepository.findByNomeContainsIgnoreCase(it)
        }
        return categoriaRepository.findAll()
    }

    fun criar(categoria: Categoria): Categoria =
        categoriaRepository.save(categoria)

    fun buscarPorId(id: Long) =
        categoriaRepository.findById(id).orElseThrow()

    fun atualizar(categoria: Categoria): Categoria {

        if (!categoriaRepository.existsById(categoria.id!!)) {
            throw NotFoundException(Errors.CATEGORIA_NAO_ENCONTRADA.code, Errors.CATEGORIA_NAO_ENCONTRADA.message.format(categoria.id))
        }

        return categoriaRepository.save(categoria)
    }

    fun delete(id: Long) {

        if (!categoriaRepository.existsById(id)) {
            throw Exception()
        }

        return categoriaRepository.deleteById(id)
    }

}