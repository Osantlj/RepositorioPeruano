package com.senac.projeto2.service;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.repository.PremioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioService {
    private final PremioRepository repository;

    public PremioService(PremioRepository repository) { this.repository = repository; }

    public List<Premio> listar() { return repository.findAll(); }
    public Premio buscarPorId(int id) { return repository.findById(id).orElse(null); }
    public Premio salvar(Premio p) { return repository.save(p); }

    public Premio atualizar(int id, Premio dados) {
        Premio atual = buscarPorId(id);
        if (atual == null) return null;
        atual.setDescricao(dados.getDescricao());
        atual.setOrdemPremiacao(dados.getOrdemPremiacao());
        atual.setCategoria(dados.getCategoria());
        atual.setStatus(dados.getStatus());
        return repository.save(atual);
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
