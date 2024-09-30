package br.com.fiap.challenge.model;

import java.time.LocalDate;

public class Aula {
    private int idAula;
    private String titulo;
    private String descricao;
    private LocalDate data;
    private Professor professor;
    private Sala sala;

    public Aula(int idAula, String titulo, String descricao, LocalDate data, Professor professor, Sala sala) {
        this.idAula = idAula;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.professor = professor;
        this.sala = sala;
    }

    public int getIdAula() {
        return this.idAula;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Sala getSala() {
        return this.sala;
    }
}
