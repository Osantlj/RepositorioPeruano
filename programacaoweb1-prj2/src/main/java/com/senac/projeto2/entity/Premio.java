package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "premio_id")
    private int id;

    @Column(name = "premio_descricao", nullable = false, length = 300)
    private String descricao;

    @Column(name = "premio_ordem_premiacao", nullable = false)
    private int ordemPremiacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "premio_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "premio_status", nullable = false)
    private int status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getOrdemPremiacao() { return ordemPremiacao; }
    public void setOrdemPremiacao(int ordemPremiacao) { this.ordemPremiacao = ordemPremiacao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}
