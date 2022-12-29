package com.bora.lancamentos.repository

import com.bora.lancamentos.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {

    fun findByNomeContainsIgnoreCase(nome: String): List<Categoria>
}