package negocio.aluno;

import negocio.aluno.entidade.Aluno;
import negocio.aluno.entidade.Endereco;
import negocio.enums.Cursos;
import negocio.interf.IFachadaAluno;
import negocio.excecoes.AlunoInexistenteException;
import negocio.excecoes.AlunoJaCadastradoException;

public class FachadaAluno implements IFachadaAluno {
  private ControladorAluno controladorAluno;

  public FachadaAluno(){
    this.controladorAluno = new ControladorAluno();
  }

  @Override
  public void inserirAluno(Aluno aluno) throws AlunoJaCadastradoException {
    this.controladorAluno.inserirNovoAluno(aluno);
  }

  @Override
  public void editarAluno(Aluno aluno, String novoNome) throws AlunoInexistenteException {
      this.controladorAluno.editarAluno(aluno, novoNome);
  }

  @Override
  public void editarAluno(Aluno aluno, Cursos curso) throws AlunoInexistenteException {
    this.controladorAluno.editarAluno(aluno, curso);
  }

  @Override
  public void editarAluno(Aluno aluno, Endereco novoEndereco) throws AlunoInexistenteException {
    this.controladorAluno.editarAluno(aluno, novoEndereco);
  }

  @Override
  public void removerAluno(Aluno aluno) throws AlunoInexistenteException {
      this.controladorAluno.removerAluno(aluno);
  }

  @Override
  public Aluno buscarAluno(String nomeAluno) throws AlunoInexistenteException {
    return this.controladorAluno.buscarAlunoPorNome(nomeAluno);
  }
}
