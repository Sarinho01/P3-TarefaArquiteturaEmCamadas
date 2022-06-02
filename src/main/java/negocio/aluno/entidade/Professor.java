package negocio.aluno.entidade;

import negocio.enums.Cursos;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private Endereco endereco;
    private String matricula;
    private ArrayList<Cursos> cursos;

    public Professor(String nome, Endereco endereco, String matricula, ArrayList<Cursos> cursos) {
        this.cursos = cursos;
        this.nome = nome;
        this.endereco = endereco;
        this.matricula = matricula;
    }

    public void removerCurso(Cursos cursoRemover){
        cursos.remove(cursoRemover);
        throw new RuntimeException("Curso não encontrado!");
    }

    public void adicionarCurso(Cursos curso){
        if(!cursos.contains(curso)){
            cursos.add(curso);
        }
        throw new RuntimeException("Curso já existe!");

    }

    public ArrayList<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Cursos> cursos) {
        this.cursos = cursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
