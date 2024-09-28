package br.com.fiap.challenge;

import br.com.fiap.challenge.model.Aluno;
import br.com.fiap.challenge.model.Aula;
import br.com.fiap.challenge.model.Professor;
import br.com.fiap.challenge.model.Sala;
import br.com.fiap.challenge.service.SistemaReserva;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SistemaReserva sistema = new SistemaReserva();
        Scanner scanner = new Scanner(System.in);

        // Criar professores e alunos
        Professor prof1 = new Professor("Dr. Silva", "dr.silva@fmusp.br");
        sistema.adicionarProfessor(prof1);

        Aluno aluno1 = new Aluno("Maria", "maria@fmusp.br");
        Aluno aluno2 = new Aluno("João", "joao@fmusp.br");
        sistema.adicionarAluno(aluno1);
        sistema.adicionarAluno(aluno2);

        Sala sala1 = new Sala("sala1",30);

        boolean executando = true;
        while (executando) {
            System.out.println("Menu:");
            System.out.println("1. Professor: Marcar Aula");
            System.out.println("2. Aluno: Registrar Aula");
            System.out.println("3. Aluno: Marcar Aula");
            System.out.println("4. Ver Informações do Aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Professor: Marcar Aula");
                    System.out.print("Título da Aula: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição da Aula: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a sala: ");
                    Aula novaAula = new Aula(titulo, descricao, prof1,sala1);
                    System.out.println("Aula marcada com sucesso!");
                    break;

                case 2:
                    System.out.println("Aluno: Registrar Aula");
                    System.out.println("Escolha um aluno:");
                    List<Aluno> alunos = sistema.listarAlunos();
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    int escolhaAluno = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Aluno alunoSelecionado = alunos.get(escolhaAluno);
                    System.out.println("Registrando participação na aula para " + alunoSelecionado.getNome());
                    System.out.println("Participação registrada!");
                    break;

                case 3:
                    System.out.println("Aluno: Marcar Aula");
                    System.out.println("Escolha um aluno:");
                    alunos = sistema.listarAlunos();
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    escolhaAluno = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    alunoSelecionado = alunos.get(escolhaAluno);
                    System.out.println("Escolha uma aula:");
                    System.out.println("Marque a aula para o aluno " + alunoSelecionado.getNome());
                    break;

                case 4:
                    System.out.println("Ver Informações do Aluno");
                    System.out.println("Escolha um aluno:");
                    alunos = sistema.listarAlunos();
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    escolhaAluno = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    alunoSelecionado = alunos.get(escolhaAluno);
                    System.out.println("Aluno: " + alunoSelecionado.getNome() + ", Email: " + alunoSelecionado.getEmail());
                    break;

                case 5:
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
