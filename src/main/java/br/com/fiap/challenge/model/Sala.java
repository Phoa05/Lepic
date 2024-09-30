package br.com.fiap.challenge.model;

public class Sala {
    private int idSala;
    private String numero;
    private int capacidade;

    public Sala(int idSala, String numero, int capacidade) {
        this.idSala = idSala;
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getIdSala() {
        return this.idSala;
    }

    public String getNumero() {
        return this.numero;
    }

    public int getCapacidade() {
        return this.capacidade;
    }
}
