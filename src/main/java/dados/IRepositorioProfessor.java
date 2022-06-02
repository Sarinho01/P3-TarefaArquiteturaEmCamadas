package dados;


import negocio.aluno.entidade.Endereco;
import negocio.aluno.entidade.Professor;
import negocio.enums.Cursos;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;

import java.util.ArrayList;

public interface IRepositorioProfessor {
    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException;

    public boolean verificarExistenciaProfessor(String matricula);

    public Professor buscarProfessor(String nomeProfessor) throws ProfessorInexistenteException;

    public void removerProfessor(Professor professor) throws ProfessorInexistenteException;

    public void editarProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException;

    public void editarProfessor(Professor professor, ArrayList<Cursos> cursos) throws ProfessorInexistenteException;

    public void editarProfessor(Professor professor, Endereco endereco) throws ProfessorInexistenteException;
}
