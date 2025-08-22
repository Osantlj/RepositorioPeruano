package com.senac.projeto2.service;

import com.senac.projeto2.entity.Participante;
import com.senac.projeto2.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository repository;

    public ParticipanteService(ParticipanteRepository repository) { this.repository = repository; }

    public List<Participante> listar() { return repository.findAll(); }
    public Participante buscarPorId(int id) { return repository.findById(id).orElse(null); }
    public Participante salvar(Participante p) { return repository.save(p); }

    public Participante atualizar(int id, Participante dados) {
        Participante atual = buscarPorId(id);
        if (atual == null) return null;
        atual.setNome(dados.getNome());
        atual.setEmail(dados.getEmail());
        atual.setIdentificacao(dados.getIdentificacao());
        atual.setEndereco(dados.getEndereco());
        atual.setFotoPerfil(dados.getFotoPerfil());
        atual.setStatus(dados.getStatus());
        return repository.save(atual);
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
