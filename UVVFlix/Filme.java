package ProjetoUvvFlix;

import java.util.List;
import java.util.ArrayList;

public class Filme {
    private int idFilme;
    private String titulo;
    private long duracao;
    private String genero;
    private List<Ator> atores;

    public Filme(int idFilme, String titulo, long duracao, String genero) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.atores = new ArrayList<>();
    }

    public void adicionarAtor(Ator ator) {
        if (!atores.contains(ator)) {
            atores.add(ator);
        }
    }

    public void removerAtor(Ator ator) {
        atores.remove(ator);
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
