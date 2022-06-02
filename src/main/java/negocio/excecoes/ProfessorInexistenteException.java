package negocio.excecoes;

public class ProfessorInexistenteException extends Exception{
    public ProfessorInexistenteException(){
        super("Professor já cadastrado!");
    }
}
