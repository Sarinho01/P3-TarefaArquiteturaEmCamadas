import gui.MenuPrincipal;
import negocio.aluno.FachadaAluno;
import negocio.interf.IFachadaAluno;
import negocio.interf.IFachadaProfessor;
import negocio.professor.FachadaProfessor;

public class AplicacaoSysUnicap {
  public static void main(String[] args){
    IFachadaAluno fachadaAluno = new FachadaAluno();
    IFachadaProfessor fachadaProfessor = new FachadaProfessor();

    MenuPrincipal menuPrincipal = new MenuPrincipal();
    menuPrincipal.iniciar(fachadaAluno, fachadaProfessor);


  }
}
