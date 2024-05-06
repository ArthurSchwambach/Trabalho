package ProjetoUvvFlix;

import java.util.Map;
import java.util.HashMap;

public class Sala {
    private String identificador;
    private String numeroAssentos;
    private String tipoTela;
    private String localizacao;
    private Map<String, Sessao> listaSessoes;

    public Sala(String identificador, String numeroAssentos, String tipoTela, String localizacao) {
        this.identificador = identificador;
        this.numeroAssentos = numeroAssentos;
        this.tipoTela = tipoTela;
        this.localizacao = localizacao;
        this.listaSessoes = new HashMap<>();
    }

    public void adicionarSessao(Sessao sessao) {
        listaSessoes.put(sessao.getHorario(), sessao);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(String numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Map<String, Sessao> getListaSessoes() {
        return listaSessoes;
    }

    public void setListaSessoes(Map<String, Sessao> listaSessoes) {
        this.listaSessoes = listaSessoes;
    }

}

