package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
@Tag(name="Categoria", description="API para gerenciamento de categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) { this.service = service; }

    @GetMapping
    @Operation(summary="Listar categorias")
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar categoria por id")
    public ResponseEntity<Categoria> buscar(@PathVariable int id) {
        Categoria c = service.buscarPorId(id);
        return (c == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(c);
    }

    @PostMapping
    @Operation(summary="Criar categoria")
    public String criar(@RequestBody Categoria c) {
        service.salvar(c);
        return "Categoria criada com sucesso!";
    }

    @PutMapping("/{id}")
    @Operation(summary="Atualizar categoria")
    public String atualizar(@PathVariable int id, @RequestBody Categoria c) {
        return (service.atualizar(id, c) == null) ? "Categoria não encontrada!" : "Categoria atualizada com sucesso!";
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Apagar categoria")
    public String apagar(@PathVariable int id) {
        return service.deletar(id) ? "Categoria apagada com sucesso!" : "Categoria não encontrada!";
    }
}
