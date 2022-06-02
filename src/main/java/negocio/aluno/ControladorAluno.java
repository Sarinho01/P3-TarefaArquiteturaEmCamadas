package negocio.aluno;

import dados.IRepositorioAluno;
import dados.aluno.RepositorioAluno;
import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.enums.Cursos;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public class ControladorAluno {
  private IRepositorioAluno repositorioAluno;

  public ControladorAluno(){
    this.repositorioAluno = new RepositorioAluno();
  }




  public void inserirNovoAluno(Aluno aluno) throws AlunoJaCadastradoException {
    this.repositorioAluno.inserirAluno(aluno);
  }
  public void removerAluno(Aluno aluno) throws AlunoInexistenteException{
      this.repositorioAluno.removerAluno(aluno);
  }

  public Aluno buscarAlunoPorNome(String nomeAluno) throws AlunoInexistenteException {
    return this.repositorioAluno.buscarAluno(nomeAluno);
  }

  public boolean verificarExistenciaAluno(String matricula){
    return this.repositorioAluno.verificarExistenciaAluno(matricula);
  }


  public void editarAluno(Aluno aluno, String novoNome) throws AlunoInexistenteException {
    this.repositorioAluno.editarAluno(aluno, novoNome);
  }

  public void editarAluno(Aluno aluno, Cursos curso) throws AlunoInexistenteException {
    this.repositorioAluno.editarAluno(aluno, curso);
  }

  public void editarAluno(Aluno aluno, Endereco endereco) throws AlunoInexistenteException {
    this.repositorioAluno.editarAluno(aluno, endereco);
  }
}
