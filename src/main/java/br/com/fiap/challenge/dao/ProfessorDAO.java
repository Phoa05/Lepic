package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.dao.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    // Método para adicionar professor
    public void adicionarProfessor(Professor professor) {
        String sql = "INSERT INTO Professor (nome, email) VALUES (?, ?)";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.executeUpdate();
            System.out.println("Professor adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar professor.");
            e.printStackTrace();
        }
    }

    // Método para listar todos os professores
    public List<Professor> listarProfessores() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM Professor";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Professor professor = new Professor(rs.getInt("id_professor"),
                        rs.getString("nome"),
                        rs.getString("email"));
                professores.add(professor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar professores.");
            e.printStackTrace();
        }
        return professores;
    }
    public Professor buscarProfessorPorId(int id) {
        return new Professor(id, "Professor Exemplo", "email@exemplo.com");
    }
}
