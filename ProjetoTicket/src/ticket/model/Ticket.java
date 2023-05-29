package ticket.model;

/**
 *
 * @author Equipe Gurutec
 */
public class Ticket {
    static int id;
    private String nome;
    private String email;
    private String cargo;
    private String unidade;
    private String tipo;
    private String assunto;
    private String texto;
    
    public Ticket(){
      
    }
    
    public Ticket(String nome, String email, String cargo, String unidade, String tipo, String assunto, String texto){
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.tipo = tipo;
    }
    
    public void gerarId(){
        id++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}
