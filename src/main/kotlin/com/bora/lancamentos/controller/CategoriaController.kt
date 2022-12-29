package com.bora.lancamentos.controller

import com.bora.lancamentos.model.Categoria
import com.bora.lancamentos.repository.CategoriaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/categorias")
class CategoriaController(
    val categoriaRepository: CategoriaRepository
) {

    @GetMapping
    fun listar(@RequestParam nome: String?): List<Categoria> {
        return if (nome.isNullOrBlank()) {
            categoriaRepository.findAll()
        } else {
            categoriaRepository.findByNomeContainsIgnoreCase(nome)
        }
    }

    @PostMapping
    fun criar(@RequestBody categoria: Categoria): ResponseEntity<Categoria> {
        val categoriaNova = categoriaRepository.save(categoria)

        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
            .path("/{id}").buildAndExpand(categoriaNova.id).toUri()

        return ResponseEntity.created(uri).body(categoriaNova);
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Categoria> =
        categoriaRepository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody categoria: Categoria): ResponseEntity<Categoria> =
        categoriaRepository.findById(id).map {
            val categoriaAtualizada = it.copy(
                nome = categoria.nome
            )
            ResponseEntity.ok(categoriaRepository.save(categoriaAtualizada))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long): ResponseEntity<Void> =
        categoriaRepository.findById(id).map {
            categoriaRepository.deleteById(id)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity<Void>(HttpStatus.NOT_FOUND))


}