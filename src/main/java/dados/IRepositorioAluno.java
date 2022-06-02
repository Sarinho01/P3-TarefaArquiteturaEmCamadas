package dados;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.enums.Cursos;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public interface IRepositorioAluno {

  public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException;

  public boolean verificarExistenciaAluno(String matricula);

  public Aluno buscarAluno(String nomeAluno) throws AlunoInexistenteException;

  public void removerAluno(Aluno aluno) throws AlunoInexistenteException;

  public void editarAluno(Aluno aluno, String novoNome) throws AlunoInexistenteException;

  public void editarAluno(Aluno aluno, Cursos curso) throws AlunoInexistenteException;

  public void editarAluno(Aluno aluno, Endereco endereco) throws AlunoInexistenteException;
}
