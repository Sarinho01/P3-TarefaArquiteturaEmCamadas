package negocio.professor;


import negocio.aluno.entidade.Endereco;
import negocio.aluno.entidade.Professor;
import negocio.enums.Cursos;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;
import negocio.interf.IFachadaProfessor;

import java.util.ArrayList;

public class FachadaProfessor implements IFachadaProfessor {
    private ControladorProfessor controladorProfessor ;

    public FachadaProfessor(){
        this.controladorProfessor = new ControladorProfessor();
    }

    @Override
    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException {
        this.controladorProfessor.inserirProfessor(professor);
    }

    @Override
    public void editarProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException {
        this.controladorProfessor.editarProfessor(professor, novoNome);
    }

    @Override
    public void editarProfessor(Professor professor, ArrayList<Cursos> cursos) throws ProfessorInexistenteException {
        this.controladorProfessor.editarProfessor(professor, cursos);
    }

    @Override
    public void editarProfessor(Professor professor, Endereco endereco) throws ProfessorInexistenteException {
        this.controladorProfessor.editarProfessor(professor, endereco);
    }

    @Override
    public void removerProfessor(Professor professor) throws ProfessorInexistenteException {
        this.controladorProfessor.removerProfessor(professor);

    }

    @Override
    public Professor buscarProfessor(String nomeProfessor) throws ProfessorInexistenteException {
        return this.controladorProfessor.buscarProfessor(nomeProfessor);
    }
}
