package com.senac.projeto2.service;

import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario listarUsuarioPorId(int idUsuario){
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }
}
