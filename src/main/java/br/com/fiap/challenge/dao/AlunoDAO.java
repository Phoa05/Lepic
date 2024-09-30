package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    // Método para adicionar aluno
    public void adicionarAluno(Aluno aluno) {
        String sql = "INSERT INTO Aluno (nome, email, pontuacao, nivel) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getPontuacao());
            stmt.setInt(4, aluno.getNivel());
            stmt.executeUpdate();
            System.out.println("Aluno adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar aluno.");
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
