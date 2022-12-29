package com.bora.lancamentos.controller

import com.bora.lancamentos.model.Categoria
import com.bora.lancamentos.model.Pessoa
import com.bora.lancamentos.service.PessoaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/pessoas")
class PessoalController(
    val pessoaService: PessoaService
) {

    @PostMapping
    fun criar(@RequestBody dto: CreatePessoaRequest): ResponseEntity<Pessoa> {
        val pessoaNova = pessoaService.criar(dto)

        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
            .path("/{id}").buildAndExpand(pessoaNova.id).toUri()

        return ResponseEntity.created(uri).body(pessoaNova);
    }
}