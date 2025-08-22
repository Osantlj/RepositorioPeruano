package com.senac.projeto2.service;

import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() { return repository.findAll(); }

    public Categoria buscarPorId(int id) { return repository.findById(id).orElse(null); }

    public Categoria salvar(Categoria c) { return repository.save(c); }

    public Categoria atualizar(int id, Categoria dados) {
        Categoria atual = buscarPorId(id);
        if (atual == null) return null;
        atual.setNome(dados.getNome());
        atual.setStatus(dados.getStatus());
        return repository.save(atual);
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
