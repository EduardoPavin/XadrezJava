package MesaDeJogo;

public class ExcecaoMesa extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcecaoMesa(String mensagem){
        super(mensagem);
    }
}
