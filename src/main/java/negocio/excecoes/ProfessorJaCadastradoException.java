package negocio.excecoes;

public class ProfessorJaCadastradoException extends  Exception{
    public ProfessorJaCadastradoException(){
        super("Professor já cadastrado!");
    }
}
