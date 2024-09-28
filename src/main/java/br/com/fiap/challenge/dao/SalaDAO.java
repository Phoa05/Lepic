package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Sala;
import br.com.fiap.challenge.dao.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private Connection connection;

    public SalaDAO() throws ClassNotFoundException, SQLException {
        this.connection = ConexaoDB.getConnection();
    }

    public void adicionarSala(Sala sala) throws SQLException {
        String sql = "INSERT INTO salas (nome, capacidade) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.executeUpdate();
        }
    }

    public List<Sala> listarSalas() throws SQLException {
        List<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM salas";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = "";
                int capacidade = 30;
                Sala sala = new Sala(nome,capacidade);
                sala.setId(rs.getInt("id"));
                sala.setNome(rs.getString("nome"));
                sala.setCapacidade(rs.getInt("capacidade"));
                salas.add(sala);
            }
        }
        return salas;
    }

    public void atualizarSala(Sala sala) throws SQLException {
        String sql = "UPDATE salas SET nome = ?, capacidade = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setInt(3, sala.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarSala(int id) throws SQLException {
        String sql = "DELETE FROM salas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
