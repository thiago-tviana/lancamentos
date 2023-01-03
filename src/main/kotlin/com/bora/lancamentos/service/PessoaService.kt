package com.bora.lancamentos.service

import com.bora.lancamentos.controller.dto.request.CreatePessoaRequest
import com.bora.lancamentos.model.Endereco
import com.bora.lancamentos.model.Pessoa
import com.bora.lancamentos.repository.PessoaRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PessoaService(
    val pessoaRepository: PessoaRepository,
    val restTemplate: RestTemplate
) {

    fun criar(dto: CreatePessoaRequest): Pessoa {
        val endereco = restTemplate.getForObject("https://viacep.com.br/ws/${dto.cep}/json", Endereco::class.java)
        return pessoaRepository.save(Pessoa(
            nome = dto.nome,
            endereco = endereco,
            id = null
        ))
    }

}