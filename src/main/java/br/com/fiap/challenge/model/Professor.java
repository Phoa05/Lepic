package br.com.fiap.challenge.model;

public class Professor extends Usuario {
    private int id;

    public Professor(int id,String nome, String email) {
        super(id,nome, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
