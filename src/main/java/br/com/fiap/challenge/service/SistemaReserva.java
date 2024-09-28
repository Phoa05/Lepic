package br.com.fiap.challenge.service;

import br.com.fiap.challenge.dao.AlunoDAO;
import br.com.fiap.challenge.dao.ProfessorDAO;
import br.com.fiap.challenge.dao.SalaDAO;
import br.com.fiap.challenge.dao.AulaDAO;
import br.com.fiap.challenge.model.Aluno;
import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.model.Sala;
import br.com.fiap.challenge.model.Aula;

import java.sql.SQLException;
import java.util.List;

public class SistemaReserva {
    private AlunoDAO alunoDAO;
    private ProfessorDAO professorDAO;
    private SalaDAO salaDAO;
    private AulaDAO aulaDAO;

    public SistemaReserva() throws ClassNotFoundException, SQLException {
        alunoDAO = new AlunoDAO();
        professorDAO = new ProfessorDAO();
        salaDAO = new SalaDAO();
        aulaDAO = new AulaDAO();
    }

    public void adicionarAluno(Aluno aluno) throws SQLException {
        alunoDAO.adicionarAluno(aluno);
    }

    public void adicionarProfessor(Professor professor) throws SQLException {
        professorDAO.adicionarProfessor(professor);
    }

    public void adicionarSala(Sala sala) throws SQLException {
        salaDAO.adicionarSala(sala);
    }

    public void adicionarAula(Aula aula) throws SQLException {
        aulaDAO.adicionarAula(aula);
    }

    public List<Aluno> listarAlunos() throws SQLException {
        return alunoDAO.listarAlunos();
    }

    public List<Professor> listarProfessores() throws SQLException {
        return professorDAO.listarProfessores();
    }

    public List<Sala> listarSalas() throws SQLException {
        return salaDAO.listarSalas();
    }

    public List<Aula> listarAulas() throws SQLException {
        return aulaDAO.listarAulas();
    }
}
