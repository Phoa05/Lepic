package br.com.fiap.challenge;

import br.com.fiap.challenge.dao.AlunoDAO;
import br.com.fiap.challenge.dao.ProfessorDAO;
import br.com.fiap.challenge.dao.SalaDAO;
import br.com.fiap.challenge.model.Aluno;
import br.com.fiap.challenge.model.Aula;
import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.model.Sala;
import br.com.fiap.challenge.service.CriarTabelas;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CriarTabelas.criarTabelas();

        Scanner scanner = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        SalaDAO salaDAO = new SalaDAO();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Sala");
            System.out.println("4. Cadastrar Aula");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Email do Aluno: ");
                    String emailAluno = scanner.nextLine();
                    Aluno aluno = new Aluno(0, nomeAluno, emailAluno, 0, 1);
                    alunoDAO.adicionarAluno(aluno);
                    System.out.println("Aluno cadastrado com sucesso.");
                    break;

                case 2:
                    System.out.print("Nome do Professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Email do Professor: ");
                    String emailProfessor = scanner.nextLine();
                    Professor professor = new Professor(0, nomeProfessor, emailProfessor);
                    professorDAO.adicionarProfessor(professor);
                    System.out.println("Professor cadastrado com sucesso.");
                    break;

                case 3: // Cadastrar Sala
                    System.out.print("Número da Sala: ");
                    String numeroSala = scanner.nextLine();
                    System.out.print("Capacidade da Sala: ");
                    int capacidadeSala = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    Sala sala = new Sala(0, numeroSala, capacidadeSala);
                    salaDAO.adicionarSala(sala);
                    System.out.println("Sala cadastrada com sucesso.");
                    break;

                case 4: // Cadastrar Aula
                    System.out.print("Título da Aula: ");
                    String tituloAula = scanner.nextLine();
                    System.out.print("Descrição da Aula: ");
                    String descricaoAula = scanner.nextLine();
                    System.out.print("Data da Aula (YYYY-MM-DD): ");
                    String dataAulaStr = scanner.nextLine();
                    LocalDate dataAula = LocalDate.parse(dataAulaStr);

                    System.out.print("ID do Professor: ");
                    int idProfessorAula = scanner.nextInt();
                    Professor prof = professorDAO.buscarProfessorPorId(idProfessorAula);
                    if (prof == null) {
                        System.out.println("Professor não encontrado.");
                        break;
                    }

                    System.out.print("ID da Sala: ");
                    int idSalaAula = scanner.nextInt();
                    Sala sal = salaDAO.buscarSalaPorId(idSalaAula);
                    if (sal == null) {
                        System.out.println("Sala não encontrada.");
                        break;
                    }

                    Aula aula = new Aula(0, tituloAula, descricaoAula, dataAula, prof, sal);
                    System.out.println("Aula cadastrada com sucesso.");
                    break;

                case 5: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
