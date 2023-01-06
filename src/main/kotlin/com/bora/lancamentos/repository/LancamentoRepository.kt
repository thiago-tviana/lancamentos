package com.bora.lancamentos.repository

import com.bora.lancamentos.model.Categoria
import com.bora.lancamentos.model.Lancamento
import com.bora.lancamentos.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LancamentoRepository: JpaRepository<Lancamento, Long> {
}