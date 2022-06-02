package negocio.interf;

import negocio.aluno.entidade.Endereco;
import negocio.aluno.entidade.Professor;
import negocio.enums.Cursos;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;

import java.util.ArrayList;

public interface IFachadaProfessor {

    void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException;

    void editarProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException;

    void editarProfessor(Professor professor, ArrayList<Cursos> cursos) throws ProfessorInexistenteException;

    void editarProfessor(Professor professor, Endereco endereco) throws ProfessorInexistenteException;

    void removerProfessor(Professor professor) throws ProfessorInexistenteException;

    Professor buscarProfessor(String nomeProfessor) throws ProfessorInexistenteException;
}
