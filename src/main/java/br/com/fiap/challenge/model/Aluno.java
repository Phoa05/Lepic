package br.com.fiap.challenge.model;

public class Aluno extends Usuario {
    private int idAluno;
    private int pontuacao;
    private int nivel;

    public Aluno(int idAluno,String nome, String email, int pontuacao, int nivel) {
        super(idAluno,nome, email);
        this.pontuacao = pontuacao;
        this.nivel = nivel;
    }

    public int getIdAluno() {
        return this.idAluno;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
