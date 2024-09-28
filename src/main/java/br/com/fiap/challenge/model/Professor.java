package br.com.fiap.challenge.model;

public class Professor extends Usuario {
    private int id;

    public Professor(String nome, String email) {
        super(nome, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
