package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Sala;
import br.com.fiap.challenge.dao.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    // Método para adicionar sala
    public void adicionarSala(Sala sala) {
        String sql = "INSERT INTO Sala (numero, capacidade) VALUES (?, ?)";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sala.getNumero());
            stmt.setInt(2, sala.getCapacidade());
            stmt.executeUpdate();
            System.out.println("Sala adicionada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar sala.");
            e.printStackTrace();
        }
    }

    // Método para listar todas as salas
    public List<Sala> listarSalas() {
        List<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM Sala";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Sala sala = new Sala(rs.getInt("id_sala"),
                        rs.getString("numero"),
                        rs.getInt("capacidade"));
                salas.add(sala);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar salas.");
            e.printStackTrace();
        }
        return salas;
    }
    public Sala buscarSalaPorId(int id) {
        // Simulação de busca no banco de dados
        return new Sala(id, "101", 30);
    }
}
