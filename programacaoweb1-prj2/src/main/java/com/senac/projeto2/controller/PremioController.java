package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.service.PremioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/premios")
@Tag(name="Premio", description="API para gerenciamento de prêmios")
public class PremioController {

    private final PremioService service;

    public PremioController(PremioService service) { this.service = service; }

    @GetMapping
    @Operation(summary="Listar prêmios")
    public ResponseEntity<List<Premio>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar prêmio por id")
    public ResponseEntity<Premio> buscar(@PathVariable int id) {
        Premio p = service.buscarPorId(id);
        return (p == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(p);
    }

    @PostMapping
    @Operation(summary="Criar prêmio")
    public String criar(@RequestBody Premio p) {
        service.salvar(p);
        return "Prêmio criado com sucesso!";
    }

    @PutMapping("/{id}")
    @Operation(summary="Atualizar prêmio")
    public String atualizar(@PathVariable int id, @RequestBody Premio p) {
        return (service.atualizar(id, p) == null) ? "Prêmio não encontrado!" : "Prêmio atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Apagar prêmio")
    public String apagar(@PathVariable int id) {
        return service.deletar(id) ? "Prêmio apagado com sucesso!" : "Prêmio não encontrado!";
    }
}
