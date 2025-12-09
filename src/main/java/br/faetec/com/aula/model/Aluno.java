package br.faetec.com.aula.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_caixa", nullable = false)
    private String numeroCaixa;

    @Column(name = "numero_pasta", nullable = false)
    private String numeroPasta;

    @Column(name = "nome_aluno", nullable = false)
    private String nomeAluno;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "obs")
    private String obs;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa != null ? numeroCaixa.toUpperCase() : null;
    }

    public String getNumeroPasta() {
        return numeroPasta;
    }

    public void setNumeroPasta(String numeroPasta) {
        this.numeroPasta = numeroPasta != null ? numeroPasta.toUpperCase() : null;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno != null ? nomeAluno.toUpperCase() : null;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel != null ? nomeResponsavel.toUpperCase() : null;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs != null ? obs.toUpperCase() : null;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
