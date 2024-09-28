package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Aula;
import br.com.fiap.challenge.dao.ConexaoDB;
import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {
    private Connection connection;

    public AulaDAO() throws ClassNotFoundException, SQLException {
        this.connection = ConexaoDB.getConnection();
    }

    public void adicionarAula(Aula aula) throws SQLException {
        String sql = "INSERT INTO aulas (titulo, descricao, professor_id, sala_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aula.getTitulo());
            stmt.setString(2, aula.getDescricao());
            stmt.setInt(3, aula.getProfessor().getId());
            stmt.setInt(4, aula.getSala().getId());
            stmt.executeUpdate();
        }
    }

    public List<Aula> listarAulas() throws SQLException {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM aulas";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String titulo = "";
                String descricao = "";
                String nome = "";
                String email = "";
                Professor professor = new Professor(nome,email);
                int capacidade = 30;
                Sala sala = new Sala(nome,capacidade);
                Aula aula = new Aula(titulo,descricao,professor,sala);
                aula.setId(rs.getInt("id"));
                aula.setTitulo(rs.getString("titulo"));
                aula.setDescricao(rs.getString("descricao"));
                // Aqui você deve buscar o professor e a sala correspondentes.
                aulas.add(aula);
            }
        }
        return aulas;
    }

    public void atualizarAula(Aula aula) throws SQLException {
        String sql = "UPDATE aulas SET titulo = ?, descricao = ?, professor_id = ?, sala_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aula.getTitulo());
            stmt.setString(2, aula.getDescricao());
            stmt.setInt(3, aula.getProfessor().getId());
            stmt.setInt(4, aula.getSala().getId());
            stmt.setInt(5, aula.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarAula(int id) throws SQLException {
        String sql = "DELETE FROM aulas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
