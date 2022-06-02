package negocio.aluno.entidade;

import negocio.enums.Cursos;

public class Aluno {
  private String matricula;
  private String nome;
  private Endereco endereco;
  private Cursos cursos;

  public Aluno(String nome, String matricula, Endereco endereco, Cursos cursos){
    this.nome = nome;
    this.cursos = cursos;
    this.endereco = endereco;
    this.matricula = matricula;
  }

  public Cursos getCursos() {
    return cursos;
  }

  public void setCursos(Cursos cursos) {
    this.cursos = cursos;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
