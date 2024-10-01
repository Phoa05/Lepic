package br.com.fiap.challenge.service;

import br.com.fiap.challenge.dao.ConexaoDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {
    public static void criarTabelas() {
        String url = "jdbc:sqlite:meu_banco.db";

        String sqlAluno = "CREATE TABLE IF NOT EXISTS Aluno (" +
                "idAluno INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "pontuacao INTEGER," +
                "nivel INTEGER" +
                ");";

        String sqlProfessor = "CREATE TABLE IF NOT EXISTS Professor (" +
                "idProfessor INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "email TEXT NOT NULL" +
                ");";

        String sqlSala = "CREATE TABLE IF NOT EXISTS Sala (" +
                "idSala INTEGER PRIMARY KEY AUTOINCREMENT," +
                "numero TEXT NOT NULL," +
                "capacidade INTEGER NOT NULL" +
                ");";

        String sqlAula = "CREATE TABLE IF NOT EXISTS Aula (" +
                "idAula INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "descricao TEXT NOT NULL," +
                "data DATE NOT NULL," +
                "idProfessor INTEGER," +
                "idSala INTEGER," +
                "FOREIGN KEY (idProfessor) REFERENCES Professor(idProfessor)," +
                "FOREIGN KEY (idSala) REFERENCES Sala(idSala)" +
                ");";

        try (Connection conn = ConexaoDB.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlAluno);
            stmt.execute(sqlProfessor);
            stmt.execute(sqlSala);
            stmt.execute(sqlAula);
            System.out.println("Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

