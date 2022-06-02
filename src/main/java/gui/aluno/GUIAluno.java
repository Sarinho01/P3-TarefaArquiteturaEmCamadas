package gui.aluno;


import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.enums.Cursos;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;
import negocio.interf.IFachadaAluno;

import java.util.Scanner;

public class GUIAluno {
    public void guiAlunoIniciar(IFachadaAluno fachadaAluno) {
        Scanner input = new Scanner(System.in);

        while (true) {
            menuGuiAluno();
            int opcaoEscolhida = input.nextInt();

            try {
                switch (opcaoEscolhida) {
                    case 1 -> inserirAluno(fachadaAluno);
                    case 2 -> removerAluno(fachadaAluno);
                    case 3 -> editarAluno(fachadaAluno);
                    case 4 -> buscarAluno(fachadaAluno);
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (AlunoInexistenteException alunoInexistenteException) {
                System.out.println("Aluno não encontrado!");
            } catch (AlunoJaCadastradoException alunoJaCadastradoException) {
                System.out.println("Aluno já cadastrado!");
            } catch (Exception e) {
                System.out.println("Dado inserido incorreto!");
            }
        }

    }


    public void menuGuiAluno() {
        System.out.print("""
                ------------------------
                1 - Inserir aluno;
                2 - Remover aluno;
                3 - Editar informações
                    de um aluno;
                4 - Buscar algum aluno;
                5 - Voltar para o menu
                    principal.
                                
                Escolha uma das opções:\040
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

    public void menuEditarAluno() {
        System.out.print("""
                Digite o que você quer editar:
                1 - Curso;
                2 - Nome;
                3 - Endereço.
                Opção escolhida:\040
                """);
    }

    public void inserirAluno(IFachadaAluno fachadaAluno) throws AlunoJaCadastradoException {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("Digite as informações do novo aluno:");
        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Matricula: ");
        String matricula = input.nextLine();

        System.out.print("Rua: ");
        String rua = input.nextLine();

        System.out.print("Número do apt/casa: ");
        int numeroCasa = input.nextInt();

        Endereco endereco = new Endereco(rua, numeroCasa);

        menuCurso();
        int opcaoEscolhidaCurso = input.nextInt();
        Cursos curso = escolherCurso(opcaoEscolhidaCurso);
        if (curso == null) {
            return;
        }

        Aluno aluno = new Aluno(nome, matricula, endereco, curso);
        fachadaAluno.inserirAluno(aluno);
        System.out.println("Aluno inserido com sucesso!!!");
    }

    private void removerAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException {
        System.out.println("------------------------");
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do aluno a ser removido: ");
        String nomeAluno = input.nextLine();

        Aluno aluno = fachadaAluno.buscarAluno(nomeAluno);
        fachadaAluno.removerAluno(aluno);
        System.out.println("Aluno removido com sucesso!");

    }

    private void editarAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("Digite o nome do aluno: ");
        String nomeAluno = input.nextLine();
        Aluno aluno = fachadaAluno.buscarAluno(nomeAluno);

        menuEditarAluno();
        int opcaoEscolhida = input.nextInt();
        switch (opcaoEscolhida) {
            case 1 -> {
                menuCurso();
                int opcaoNovoCurso = input.nextInt();
                Cursos cursoEscolhido = escolherCurso(opcaoNovoCurso);
                if (cursoEscolhido == null) {
                    return;
                }
                fachadaAluno.editarAluno(aluno, cursoEscolhido);
                System.out.println("Curso alterado com sucesso!");

            }
            case 2 -> {
                System.out.print("Digite o novo nome: ");
                input.nextLine();
                String novoNome = input.nextLine();


                fachadaAluno.editarAluno(aluno, novoNome);
                System.out.println("Nome alterado com sucesso!");
            }
            case 3 -> {
                System.out.println("Digite o nome da rua: ");
                input.nextLine();
                String novaRua = input.nextLine();
                System.out.print("Digite o número da casa/apt: ");
                int novoNumeroCasa = input.nextInt();
                Endereco novoEndereco = new Endereco(novaRua, novoNumeroCasa);

                fachadaAluno.editarAluno(aluno, novoEndereco);
                System.out.println("Endereço alterado com sucesso!");
            }
            default -> System.out.println("Opção inválida!");
        }


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

    private void buscarAluno(IFachadaAluno fachadaAluno) throws AlunoInexistenteException {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = input.nextLine();

        Aluno aluno = fachadaAluno.buscarAluno(nomeAluno);
        String sbr = "\n" +
                "Nome do aluno: " + aluno.getNome() + "\n" +
                "Matricula: " + aluno.getMatricula() + "\n" +
                "Endereço: " + aluno.getEndereco().getRua() + ", Número " + aluno.getEndereco().getNumero() + "\n" +
                "Curso: " + aluno.getCursos();
        System.out.println(sbr);

    }
}
