package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.dao.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private Connection connection;

    public ProfessorDAO() throws ClassNotFoundException, SQLException {
        this.connection = ConexaoDB.getConnection();
    }

    public void adicionarProfessor(Professor professor) throws SQLException {
        String sql = "INSERT INTO professores (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<Professor> listarProfessores() throws SQLException {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professores";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = "";
                String email = "";
                Professor professor = new Professor(nome,email);
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professores.add(professor);
            }
        }
        return professores;
    }

    public void atualizarProfessor(Professor professor) throws SQLException {
        String sql = "UPDATE professores SET nome = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setInt(3, professor.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarProfessor(int id) throws SQLException {
        String sql = "DELETE FROM professores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
