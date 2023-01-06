package com.bora.lancamentos.service

import com.bora.lancamentos.model.Lancamento
import com.bora.lancamentos.repository.LancamentoRepository
import org.springframework.stereotype.Service

@Service
class LancamentoService(
    val lancamentoRepository: LancamentoRepository
) {

    fun criar(lancamento: Lancamento): Lancamento {
        return lancamentoRepository.save(lancamento)
    }

    fun listar(): MutableList<Lancamento> {
        return lancamentoRepository.findAll()
    }

}