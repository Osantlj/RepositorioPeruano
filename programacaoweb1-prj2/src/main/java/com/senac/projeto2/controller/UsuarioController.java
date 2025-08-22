package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description="API para gerenciamento dos usuarios do sistema")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/listarPorIdUsuario/{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
    public ResponseEntity<Usuario> listarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        Usuario usuario = usuarioService.listarUsuarioPorId(idUsuario);
        if (usuario == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(usuario);
        }

    }

    @PostMapping("/criar")
    public String criar(){
        return "Usuario Criado com sucesso!";
    }

    @PutMapping("/atualizar")
    public String atualizar(){
        return  "Usuario atualizado com sucesso!";
    }

    @DeleteMapping("/apagar")
    public String apagar(){
        return "Usuario apagado com sucesso!";
    }
}
