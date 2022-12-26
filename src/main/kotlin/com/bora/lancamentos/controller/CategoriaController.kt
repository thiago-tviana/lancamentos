package com.bora.lancamentos.controller

import com.bora.lancamentos.model.Categoria
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categorias")
class CategoriaController {

    var categorias = mutableListOf<Categoria>(
        Categoria(1, "Lazer"),
        Categoria(2, "Educação"),
        Categoria(3, "Mercado"),
        Categoria(4, "Super Mercado"),
    )

    @GetMapping
    fun listar(@RequestParam nome: String?): List<Categoria> {
        nome?.let {
            return categorias.filter { it.nome.contains(nome, true) }
        }
        return categorias
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody categoria: Categoria) {
        categoria.id = categorias.size.toLong() + 1
        categorias.add(categoria)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Categoria = categorias.first { it.id == id }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody categoria: Categoria): Categoria {
        categorias.filter { it.id == id}.first().let {
            it.nome = categoria.nome
            return it
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remover(@PathVariable("id") cod: Long) {
        val categoria = categorias.filter { it.id == cod }.first()
        categorias.remove(categoria)
    }

}