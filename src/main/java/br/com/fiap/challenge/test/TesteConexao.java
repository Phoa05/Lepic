package br.com.fiap.challenge.test;

import br.com.fiap.challenge.dao.ConexaoDB;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection cn = ConexaoDB.getConnection();
            System.out.println("Conectado com o banco de dados");
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
