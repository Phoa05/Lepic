package br.com.fiap.challenge.dao;

import br.com.fiap.challenge.model.Aula;
import br.com.fiap.challenge.dao.ConexaoDB;
import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.model.Sala;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {
    // Método para adicionar aula
    public void adicionarAula(Aula aula) {
        String sql = "INSERT INTO Aula (titulo, descricao, data, id_professor, id_sala) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aula.getTitulo());
            stmt.setString(2, aula.getDescricao());
            stmt.setString(3, aula.getData().toString()); // Converte LocalDate para String
            stmt.setInt(4, aula.getProfessor().getIdProfessor());
            stmt.setInt(5, aula.getSala().getIdSala());
            stmt.executeUpdate();
            System.out.println("Aula adicionada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar aula.");
            e.printStackTrace();
        }
    }

    // Método para listar todas as aulas
    public List<Aula> listarAulas() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM Aula";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aula aula = new Aula(rs.getInt("id_aula"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        LocalDate.parse(rs.getString("data")), // Converte String para LocalDate
                        new ProfessorDAO().buscarProfessorPorId(rs.getInt("id_professor")),
                        new SalaDAO().buscarSalaPorId(rs.getInt("id_sala")));
                aulas.add(aula);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar aulas.");
            e.printStackTrace();
        }
        return aulas;
    }
}
