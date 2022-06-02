package dados.professor;

import dados.IRepositorioProfessor;
import negocio.aluno.entidade.Endereco;
import negocio.aluno.entidade.Professor;
import negocio.enums.Cursos;
import negocio.excecoes.ProfessorInexistenteException;
import negocio.excecoes.ProfessorJaCadastradoException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProfessor implements IRepositorioProfessor {

    private List<Professor> professores;

    public RepositorioProfessor() {
        this.professores = new ArrayList<>();
    }

    @Override
    public void inserirProfessor(Professor professor) throws ProfessorJaCadastradoException {
        if (!professores.contains(professor)) {
            professores.add(professor);
        } else {
            throw new ProfessorJaCadastradoException();
        }
    }

    @Override
    public boolean verificarExistenciaProfessor(String matricula) {
        for (Professor professor : professores) {
            if (professor.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Professor buscarProfessor(String nomeProfessor) throws ProfessorInexistenteException {
        for (Professor professor : professores) {
            if (professor.getNome().equals(nomeProfessor)) {
                return professor;
            }
        }


        throw new ProfessorInexistenteException();
    }

    @Override
    public void removerProfessor(Professor professor) throws ProfessorInexistenteException {
        if (professores.contains(professor)) {
            professores.remove(professor);
        }else {
            throw new ProfessorInexistenteException();
        }
    }

    @Override
    public void editarProfessor(Professor professor, String novoNome) throws ProfessorInexistenteException {
        if (professores.contains(professor)) {
            professor.setNome(novoNome);
        } else {
            throw new ProfessorInexistenteException();
        }
    }

    @Override
    public void editarProfessor(Professor professor, ArrayList<Cursos> cursos) throws ProfessorInexistenteException {
        if (professores.contains(professor)) {
            professor.setCursos(cursos);
        }else {
            throw new ProfessorInexistenteException();
        }
    }


    @Override
    public void editarProfessor(Professor professor, Endereco endereco) throws ProfessorInexistenteException {
        if (professores.contains(professor)) {
            professor.setEndereco(endereco);
        }else {
            throw new ProfessorInexistenteException();
        }
    }
}
