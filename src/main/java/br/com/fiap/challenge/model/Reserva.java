package br.com.fiap.challenge.model;

import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private Aluno aluno;
    private Aula aula;
    private LocalDateTime dataReserva;

    public Reserva(int idReserva, Aluno aluno, Aula aula, LocalDateTime dataReserva) {
        this.idReserva = idReserva;
        this.aluno = aluno;
        this.aula = aula;
        this.dataReserva = dataReserva;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public Aula getAula() {
        return this.aula;
    }

    public LocalDateTime getDataReserva() {
        return this.dataReserva;
    }
}
