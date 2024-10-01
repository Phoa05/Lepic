package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection conn;
    public void adicionarAluno(Aluno aluno) {
        String sql = "INSERT INTO Aluno (nome, email, pontuacao, nivel) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConnection(); // Verifique se a conexão está correta
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setInt(3, aluno.getPontuacao());
            pstmt.setInt(4, aluno.getNivel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os alunos
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("id_aluno"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getInt("pontuacao"),
                        rs.getInt("nivel"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos.");
            e.printStackTrace();
        }
        return alunos;
    }
}
