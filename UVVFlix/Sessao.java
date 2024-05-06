package ProjetoUvvFlix;

import java.util.Map;
import java.util.HashMap;

public class Sessao {
    private String status;
    private String horario;
    private Map<String, Filme> listaFilmes;

    public Sessao(String status, String horario) {
        this.status = status;
        this.horario = horario;
        this.listaFilmes = new HashMap<>();
    }

    public void adicionarFilme(Filme filme) {
        listaFilmes.put(filme.getTitulo(), filme);
    }

    public void removerFilme(String tituloFilme) {
        listaFilmes.remove(tituloFilme);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Map<String, Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(Map<String, Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }
}

