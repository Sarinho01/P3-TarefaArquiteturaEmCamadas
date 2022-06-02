package negocio.excecoes;

public class AlunoInexistenteException extends Exception {
    public AlunoInexistenteException(){
        super("Aluno não encontrado!");
    }

}
