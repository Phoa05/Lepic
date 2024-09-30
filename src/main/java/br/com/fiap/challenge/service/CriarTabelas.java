package br.com.fiap.challenge.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:meu_banco.db";

        String sqlAluno = "CREATE TABLE IF NOT EXISTS Aluno (" +
                "id_aluno INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "pontuacao INTEGER DEFAULT 0, " +
                "nivel INTEGER DEFAULT 1);";

        String sqlProfessor = "CREATE TABLE IF NOT EXISTS Professor (" +
                "id_professor INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "email TEXT NOT NULL);";

        String sqlSala = "CREATE TABLE IF NOT EXISTS Sala (" +
                "id_sala INTEGER PRIMARY KEY, " +
                "numero TEXT NOT NULL, " +
                "capacidade INTEGER NOT NULL);";

        String sqlAula = "CREATE TABLE IF NOT EXISTS Aula (" +
                "id_aula INTEGER PRIMARY KEY, " +
                "titulo TEXT NOT NULL, " +
                "descricao TEXT, " +
                "data DATE NOT NULL, " +
                "id_professor INTEGER NOT NULL, " +
                "id_sala INTEGER NOT NULL," +
                "FOREIGN KEY (id_professor) REFERENCES Professor(id_professor)," +
                "FOREIGN KEY (id_sala) REFERENCES Sala(id_sala));";

        String sqlReserva = "CREATE TABLE IF NOT EXISTS Reserva (" +
                "id_reserva INTEGER PRIMARY KEY, " +
                "id_aluno INTEGER NOT NULL, " +
                "id_aula INTEGER NOT NULL, " +
                "data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (id_aluno) REFERENCES Aluno(id_aluno)," +
                "FOREIGN KEY (id_aula) REFERENCES Aula(id_aula));";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlAluno);
            stmt.execute(sqlProfessor);
            stmt.execute(sqlSala);
            stmt.execute(sqlAula);
            stmt.execute(sqlReserva);
            System.out.println("Tabelas criadas com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

