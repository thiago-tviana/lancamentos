package com.bora.lancamentos.controller

import com.bora.lancamentos.controller.dto.request.LancamentoCreateRequest
import com.bora.lancamentos.extension.toLancamento
import com.bora.lancamentos.model.Lancamento
import com.bora.lancamentos.service.LancamentoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/lancamentos")
class LancamentoController(
    val lancamentoService: LancamentoService
) {

    @GetMapping
    fun listar(): MutableList<Lancamento>{
        return lancamentoService.listar()
    }

    @PostMapping
    fun criar(@RequestBody dto: LancamentoCreateRequest): ResponseEntity<Lancamento> {

        val lancamento = lancamentoService.criar(dto.toLancamento())

        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
            .path("/{id}").buildAndExpand(lancamento.id).toUri()

        return ResponseEntity.created(uri).body(lancamento);
    }
}