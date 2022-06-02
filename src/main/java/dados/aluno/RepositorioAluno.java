package dados.aluno;

import dados.IRepositorioAluno;

import java.util.ArrayList;
import java.util.List;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.enums.Cursos;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public class RepositorioAluno implements IRepositorioAluno {
    private List<Aluno> alunos;

    public RepositorioAluno() {
        this.alunos = new ArrayList<>();
    }

    @Override
    public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException {
        if (!this.alunos.contains(aluno)) {
            this.alunos.add(aluno);
        } else {
            throw new AlunoJaCadastradoException("Aluno já cadastrado!!!");
        }
    }

    @Override
    public void removerAluno(Aluno aluno) throws AlunoInexistenteException {
        if (this.alunos.contains(aluno)) {
            this.alunos.remove(aluno);
        } else {
            throw new AlunoInexistenteException();
        }
    }

    @Override
    public void editarAluno(Aluno aluno, String novoNome) throws AlunoInexistenteException {
        if (this.alunos.contains(aluno)) {
            aluno.setNome(novoNome);
        }
        else{
            throw new AlunoInexistenteException();
        }
    }
    @Override
    public void editarAluno(Aluno aluno, Cursos curso) throws AlunoInexistenteException {
        if (this.alunos.contains(aluno)) {
            aluno.setCursos(curso);
        }
        else{
            throw new AlunoInexistenteException();
        }
    }



    @Override
    public void editarAluno(Aluno aluno, Endereco endereco) throws AlunoInexistenteException {
        if (this.alunos.contains(aluno)) {
            aluno.setEndereco(endereco);
        }
        else{
            throw new AlunoInexistenteException();
        }
    }

    @Override
    public boolean verificarExistenciaAluno(String matricula) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Aluno buscarAluno(String nomeAluno) throws AlunoInexistenteException {
        for (Aluno aluno : this.alunos) {
            if (aluno.getNome().equals(nomeAluno)) {
                return aluno;
            }
        }
        throw new AlunoInexistenteException();
    }



}
