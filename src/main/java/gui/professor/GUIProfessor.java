package gui.professor;


import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.aluno.entidade.Professor;
import negocio.enums.Cursos;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.interf.IFachadaProfessor;

import java.util.ArrayList;
import java.util.Scanner;

public class GUIProfessor {
    public void guiProfessorIniciar(IFachadaProfessor fachadaProfessor) {
        Scanner input = new Scanner(System.in);

        while (true) {
            menuGuiProfessor();
            int opcaoEscolhida = input.nextInt();

            try {
                switch (opcaoEscolhida) {
                    case 1 -> inserirProfessor(fachadaProfessor);
                    case 2 -> removerProfessor(fachadaProfessor);
                    case 3 -> editarProfessor(fachadaProfessor);
                    case 4 -> buscarProfessor(fachadaProfessor);
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (ProfessorInexistenteException professorInexistenteException) {
                System.out.println("Professor não encontrado!");
            } catch (ProfessorJaCadastradoException professorJaCadastradoException) {
                System.out.println("Professor já cadastrado!");
            } catch (Exception e) {
                System.out.println("Dado inserido incorreto!");
            }
        }

    }


    public void menuGuiProfessor() {
        System.out.print("""
                ------------------------
                1 - Inserir professor;
                2 - Remover professor;
                3 - Editar informações
                    de um professor;
                4 - Buscar algum professor;
                5 - Voltar para o menu
                    principal.
                                
                Escolha uma das opções:\040
                """);

    }

    public void menuEditarProfessor() {
        System.out.print("""
                Digite o que você quer editar:
                1 - Cursos;
                2 - Nome;
                3 - Endereço.
                Opção escolhida:\040
                """);
    }

    public void menuCurso() {
        System.out.print("""
                Digite o curso:
                1 - Ciência da computação;
                2 - Direito;
                3 - Medicina;
                4 - Design.
                Opção escolhida:\040
                """);
    }

    public void inserirProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorJaCadastradoException {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("Digite as informações do novo professor:");
        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Matricula: ");
        String matricula = input.nextLine();

        System.out.print("Rua: ");
        String rua = input.nextLine();

        System.out.print("Número do apt/casa: ");
        int numeroCasa = input.nextInt();


        Endereco endereco = new Endereco(rua, numeroCasa);

        System.out.println("Digite quantos cursos esse professor ensina: ");
        int quantidadeDeCursos = input.nextInt();

        ArrayList<Cursos> cursos = escolherCursosProfessor(quantidadeDeCursos);
        if (cursos == null) {
            return;
        }

        Professor professor = new Professor(nome, endereco, matricula, cursos);
        fachadaProfessor.inserirProfessor(professor);
        System.out.println("Professor inserido com sucesso!!!");

    }

    private void removerProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorInexistenteException {
        System.out.println("------------------------");
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do professor a ser removido: ");
        String nomeProfessor = input.nextLine();

        Professor professor = fachadaProfessor.buscarProfessor(nomeProfessor);
        fachadaProfessor.removerProfessor(professor);
        System.out.println("Professor removido com sucesso!");
    }

    private void editarProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorInexistenteException {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("Digite o nome do professor: ");
        String nomeProfessor = input.nextLine();
        Professor professor = fachadaProfessor.buscarProfessor(nomeProfessor);

        menuEditarProfessor();
        int opcaoEscolhida = input.nextInt();
        switch (opcaoEscolhida) {
            case 1 -> {
                System.out.println("Digite quantos cursos esse professor vai ensinar: ");
                int quantidadeCursos = input.nextInt();

                ArrayList<Cursos> cursos = escolherCursosProfessor(quantidadeCursos);
                if (cursos == null) {
                    return;
                }

                fachadaProfessor.editarProfessor(professor, cursos);
                System.out.println("Cursos alterados com sucesso!");


            }
            case 2 -> {
                System.out.print("Digite o novo nome: ");
                input.nextLine();
                String novoNome = input.nextLine();


                fachadaProfessor.editarProfessor(professor, novoNome);
                System.out.println("Nome alterado com sucesso!");
            }
            case 3 -> {
                System.out.println("Digite o nome da rua: ");
                input.nextLine();
                String novaRua = input.nextLine();
                System.out.print("Digite o número da casa/apt: ");
                int novoNumeroCasa = input.nextInt();
                Endereco novoEndereco = new Endereco(novaRua, novoNumeroCasa);

                fachadaProfessor.editarProfessor(professor, novoEndereco);
                System.out.println("Endereço alterado com sucesso!");
            }
            default -> System.out.println("Opção inválida!");
        }

    }

    private void buscarProfessor(IFachadaProfessor fachadaProfessor) throws ProfessorInexistenteException {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.print("Digite o nome do professor: ");
        String nomeProfessor = input.nextLine();

        Professor professor = fachadaProfessor.buscarProfessor(nomeProfessor);
        String sbr = "\n" +
                "Nome do professor: " + professor.getNome() + "\n" +
                "Matricula: " + professor.getMatricula() + "\n" +
                "Endereço: " + professor.getEndereco().getRua() + ", Número " + professor.getEndereco().getNumero() + "\n" +
                "Cursos ensinados: " + "\n";
        for (Cursos cursoAtual: professor.getCursos()) {
            sbr += cursoAtual + "\n";
        }

        System.out.println(sbr);
    }

    public ArrayList<Cursos> escolherCursosProfessor(int quantidadeDeCursos) {
        Scanner input = new Scanner(System.in);

        ArrayList<Cursos> cursos = new ArrayList<>();
        int cursoEscolhido;
        for (int i = 0; i < quantidadeDeCursos; i++) {
            System.out.println("Digite o curso de número " + (i + 1) + ":");
            menuCurso();

            cursoEscolhido = input.nextInt();
            Cursos novoCurso = escolherCurso(cursoEscolhido);

            if (novoCurso == null) {
                return null;
            }

            boolean cursoRepetido = verificarCursoRepetido(cursos, novoCurso);
            if (cursoRepetido) {
                System.out.println("Esse curso já foi adicionado!");
                return null;
            }

            cursos.add(novoCurso);
        }

        return cursos;
    }


    private Cursos escolherCurso(int opcaoEscolhidaCurso) {
        switch (opcaoEscolhidaCurso) {
            case 1 -> {
                return Cursos.CIENCIA_DA_COMPUTACAO;
            }
            case 2 -> {
                return Cursos.DIREITO;
            }
            case 3 -> {
                return Cursos.MEDICINA;
            }
            case 4 -> {
                return Cursos.DESIGN;
            }
            default -> {
                System.out.println("Opção inválida!");
                return null;
            }

        }
    }

    private boolean verificarCursoRepetido(ArrayList<Cursos> cursos, Cursos novoCurso) {
        for (Cursos cursoAtual : cursos) {
            if (cursoAtual == novoCurso) {
                return true;
            }
        }
        return false;
    }
}
