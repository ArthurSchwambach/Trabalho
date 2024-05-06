package iptu2;
public class Imovel {
    private String nome;
    private int meses;
    private float imposto, multa;

    // Construtor vazio para permitir a criação de um Imovel sem inicialização específica
    public Imovel() {}

    // Construtor que recebe o índice e o nome do município
    public Imovel(int i){
        InOut.MsgDeInformacao("info", "Informações do "+(i+1)+ "° Imóvel: ");
    }

    // Getters e Setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public String pegarNome(){
        this.nome = InOut.leString("Nome: ");
        return nome;
    }

    public int mesesAtraso(){
        this.meses = InOut.leInt("Meses de atraso: ");
        return meses;
    }

    public float imposto(){
        this.imposto = InOut.leFloat("Imposto: ");
        return imposto;
    }
    
     
    public void setMulta(float multa) {
        this.multa = multa;
    }
    public float getMulta() {
        return multa;
    }
    
}

