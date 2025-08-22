package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Participante;
import com.senac.projeto2.service.ParticipanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/participantes")
@Tag(name="Participante", description="API para gerenciamento de participantes")
public class ParticipanteController {

    private final ParticipanteService service;

    public ParticipanteController(ParticipanteService service) { this.service = service; }

    @GetMapping
    @Operation(summary="Listar participantes")
    public ResponseEntity<List<Participante>> listar() { return ResponseEntity.ok(service.listar()); }

    @GetMapping("/{id}")
    @Operation(summary="Buscar participante por id")
    public ResponseEntity<Participante> buscar(@PathVariable int id) {
        Participante p = service.buscarPorId(id);
        return (p == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(p);
    }

    @PostMapping
    @Operation(summary="Criar participante")
    public String criar(@RequestBody Participante p) {
        service.salvar(p);
        return "Participante criado com sucesso!";
    }

    @PutMapping("/{id}")
    @Operation(summary="Atualizar participante")
    public String atualizar(@PathVariable int id, @RequestBody Participante p) {
        return (service.atualizar(id, p) == null) ? "Participante não encontrado!" : "Participante atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Apagar participante")
    public String apagar(@PathVariable int id) {
        return service.deletar(id) ? "Participante apagado com sucesso!" : "Participante não encontrado!";
    }
}
