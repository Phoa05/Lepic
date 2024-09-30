package br.com.fiap.challenge.model;

public class Professor extends Usuario {
    private int idProfessor;

    public Professor(int idProfessor, String nome, String email) {
        super(idProfessor,nome, email);
        this.idProfessor = idProfessor;
    }

    public int getIdProfessor() {
        return this.idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
