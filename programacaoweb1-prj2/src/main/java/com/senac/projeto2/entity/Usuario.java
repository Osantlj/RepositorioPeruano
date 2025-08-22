package com.senac.projeto2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;
    @Column(name="usuario_nome", nullable = false, length = 50)
    private String nome;
    @Column(name="usuario_cpf", nullable = false, length = 11)
    private String cpf;
    @Column(name="usuario_data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name="usuario_status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
