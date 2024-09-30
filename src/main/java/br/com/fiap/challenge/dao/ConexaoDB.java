package br.com.fiap.challenge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:sqlite:meu_banco.db";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Conectado ao banco de dados SQLite.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados SQLite.");
            e.printStackTrace();
        }
        return conn;
    }
}
