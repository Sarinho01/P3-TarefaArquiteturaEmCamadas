package gui;

import gui.aluno.GUIAluno;
import gui.professor.GUIProfessor;
import negocio.interf.IFachadaAluno;
import negocio.interf.IFachadaProfessor;

import java.util.Scanner;

public class MenuPrincipal {
    public void iniciar(IFachadaAluno fachadaAluno, IFachadaProfessor fachadaProfessor) {
        Scanner input = new Scanner(System.in);
        GUIAluno guiAluno = new GUIAluno();
        GUIProfessor guiProfessor = new GUIProfessor();

        while (true) {
            menuPrincipal();
            int opcaoEscolhida = input.nextInt();

            switch (opcaoEscolhida) {
                case 1 -> guiAluno.guiAlunoIniciar(fachadaAluno);

                case 2 -> guiProfessor.guiProfessorIniciar(fachadaProfessor);

                case 3 -> {
                    return;
                }
                default -> System.out.println("Opção inválida");

            }


        }

    }

    public static void menuPrincipal() {
        System.out.print("""
                ----------------------
                1 - Entrar no menu aluno;
                2 - Entrar no menu professor;
                3 - Fechar o programa.
                                
                Escolha uma das três opções:\040
                """);
    }
}
