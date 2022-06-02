package negocio.professor;

import dados.IRepositorioProfessor;
import dados.professor.RepositorioProfessor;
import negocio.aluno.entidade.Endereco;
import negocio.aluno.entidade.Professor;
import negocio.enums.Cursos;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;

import java.util.ArrayList;

public class ControladorProfessor {
    private IRepositorioProfessor repositorioProfessor;

    public ControladorProfessor(){
        this.repositorioProfessor = new RepositorioProfessor();
    }

    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException {
        this.repositorioProfessor.inserirProfessor(professor);
    }

    public void editarProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException {
        this.repositorioProfessor.editarProfessor(professor, novoNome);
    }

    public void editarProfessor(Professor professor, ArrayList<Cursos> cursos) throws ProfessorInexistenteException {
        this.repositorioProfessor.editarProfessor(professor, cursos);
    }

    public void editarProfessor(Professor professor, Endereco endereco) throws ProfessorInexistenteException {
        this.repositorioProfessor.editarProfessor(professor, endereco);
    }

    public void removerProfessor(Professor professor) throws ProfessorInexistenteException {
        this.repositorioProfessor.removerProfessor(professor);
    }

    public Professor buscarProfessor(String nomeProfessor) throws ProfessorInexistenteException {
        return this.repositorioProfessor.buscarProfessor(nomeProfessor);
    }
}
