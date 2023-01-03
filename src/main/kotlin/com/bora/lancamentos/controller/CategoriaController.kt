package com.bora.lancamentos.controller

import com.bora.lancamentos.controller.dto.request.CreateCategoriaRequest
import com.bora.lancamentos.controller.dto.request.UpdateCategoriaRequest
import com.bora.lancamentos.extension.toCategoria
import com.bora.lancamentos.model.Categoria
import com.bora.lancamentos.repository.CategoriaRepository
import com.bora.lancamentos.service.CategoriaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/categorias")
class CategoriaController(
    val categoriaRepository: CategoriaRepository,
    val categoriaService: CategoriaService
) {

    @GetMapping
    fun listar(@RequestParam nome: String?): List<Categoria> {
        return categoriaService.listar(nome)
    }

    @PostMapping
    fun criar(@RequestBody dto: CreateCategoriaRequest): ResponseEntity<Categoria> {
        val categoriaNova = categoriaService.criar(dto.toCategoria())

        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
            .path("/{id}").buildAndExpand(categoriaNova.id).toUri()

        return ResponseEntity.created(uri).body(categoriaNova);
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Categoria> =
        ResponseEntity.ok(categoriaService.buscarPorId(id))

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody dto: UpdateCategoriaRequest): ResponseEntity<Categoria> {
        val categoria = categoriaService.atualizar(dto.toCategoria(id))
        return ResponseEntity.ok(categoria)
    }


    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long): ResponseEntity<Void> =
        categoriaRepository.findById(id).map {
            categoriaRepository.deleteById(id)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity<Void>(HttpStatus.NOT_FOUND))


}