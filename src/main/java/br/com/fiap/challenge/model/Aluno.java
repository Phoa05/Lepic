package br.com.fiap.challenge.model;

public class Aluno extends Usuario {
    private int id;

    public Aluno(int id,String nome, String email) {
        super(id, nome, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
