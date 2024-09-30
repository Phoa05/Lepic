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

    public void adicionarProfessor(Professor professor) {
        String sql = "INSERT INTO Professor (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.executeUpdate();
            System.out.println("Professor adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> listarProfessores() throws SQLException {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM Professor";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = "";
                String email = "";
                int id = 0;
                Professor professor = new Professor(id,nome,email);
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professores.add(professor);
            }
        }
        return professores;
    }

    public void atualizarProfessor(Professor professor) throws SQLException {
        String sql = "UPDATE Professor SET nome = ?, email = ? WHERE id = ?";
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
