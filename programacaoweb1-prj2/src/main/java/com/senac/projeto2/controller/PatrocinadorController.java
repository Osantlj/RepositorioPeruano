package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patrocinadores")
@Tag(name="Patrocinador", description="API para gerenciamento de patrocinadores")
public class PatrocinadorController {

    private final PatrocinadorService service;

    public PatrocinadorController(PatrocinadorService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary="Listar patrocinadores")
    public ResponseEntity<List<Patrocinador>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar patrocinador por id")
    public ResponseEntity<Patrocinador> buscar(@PathVariable int id) {
        Patrocinador p = service.buscarPorId(id);
        return (p == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(p);
    }

    @PostMapping
    @Operation(summary="Criar patrocinador")
    public String criar(@RequestBody Patrocinador p) {
        service.salvar(p);
        return "Patrocinador criado com sucesso!";
    }

    @PutMapping("/{id}")
    @Operation(summary="Atualizar patrocinador")
    public String atualizar(@PathVariable int id, @RequestBody Patrocinador p) {
        return (service.atualizar(id, p) == null)
                ? "Patrocinador não encontrado!"
                : "Patrocinador atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Apagar patrocinador")
    public String apagar(@PathVariable int id) {
        return service.deletar(id)
                ? "Patrocinador apagado com sucesso!"
                : "Patrocinador não encontrado!";
    }
}
