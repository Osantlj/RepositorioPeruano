package com.senac.projeto2.service;

import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.repository.PatrocinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinadorService {

    private final PatrocinadorRepository repository;

    public PatrocinadorService(PatrocinadorRepository repository) {
        this.repository = repository;
    }

    public List<Patrocinador> listar() {
        return repository.findAll();
    }

    public Patrocinador buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    public Patrocinador salvar(Patrocinador p) {
        return repository.save(p);
    }

    public Patrocinador atualizar(int id, Patrocinador dados) {
        Patrocinador atual = buscarPorId(id);
        if (atual == null) {
            return null;
        }
        atual.setNome(dados.getNome());
        atual.setRepresentanteNome(dados.getRepresentanteNome());
        atual.setStatus(dados.getStatus());
        return repository.save(atual);
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
