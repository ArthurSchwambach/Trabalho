package ProjetoUvvFlix;

public class Ator {
    private int idAtor;
    private String nome;
    private String papel;

    public Ator(int idAtor, String nome, String papel) {
        this.idAtor = idAtor;
        this.nome = nome;
        this.papel = papel;
    }

    public int getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(int idAtor) {
        this.idAtor = idAtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}
