package negocio.interf;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.enums.Cursos;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public interface IFachadaAluno {

  void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException;

  void editarAluno(Aluno aluno, String novoNome) throws AlunoInexistenteException;

  void editarAluno(Aluno aluno, Cursos curso) throws AlunoInexistenteException;

  void editarAluno(Aluno aluno, Endereco endereco) throws AlunoInexistenteException;

  void removerAluno(Aluno aluno) throws AlunoInexistenteException;

  Aluno buscarAluno(String nomeAluno) throws AlunoInexistenteException;

}
