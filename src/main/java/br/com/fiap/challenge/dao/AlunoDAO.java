package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection connection;

    public AlunoDAO() throws ClassNotFoundException, SQLException {
        this.connection = ConexaoDB.getConnection();
    }

    public void adicionarAluno(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO Aluno (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<Aluno> listarAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = "";
                String email = "";
                int idAluno = 0;
                Aluno aluno = new Aluno(idAluno,nome,email);
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public void atualizarAluno(Aluno aluno) throws SQLException {
        String sql = "UPDATE Aluno SET nome = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarAluno(int id) throws SQLException {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
