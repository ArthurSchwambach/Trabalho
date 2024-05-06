package ProjetoUvvFlix;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Sala> salas = new HashMap<>();
        InOut.Capa("Bem vindo(a) à UVV Flix.");

        boolean sair = false;
        while (!sair) {
            int menu = InOut.leInt(
                    "Escolha uma opção:\n"
                            + "1 - Cadastrar Sala\n"
                            + "2 - Visualizar Salas\n"
                            + "3 - Deletar Salas\n"
                            + "4 - Sair");

            if (menu == 1) {
                cadastrarSala(salas);
            } else if (menu == 2) {
                visualizarSalas(salas);
            } else if (menu == 3) {
                deletarSala(salas);
            } else if (menu == 4) {
                sair = true;
            } else {
                InOut.MsgDeErro("Opção inválida", "Escolha um valor dentre as opções disponíveis.");
            }
        }
    }

    public static void deletarSala(Map<String, Sala> salas) {
        String idSala = InOut.leString("Informe o ID da sala que deseja deletar: ");
        if (salas.containsKey(idSala)) {
            salas.remove(idSala);
            InOut.MsgDeInformacao("Deletar Sala", "Sala removida com sucesso!");
        } else {
            InOut.MsgDeErro("Erro", "Sala não encontrada.");
        }
    }

    public static void cadastrarSala(Map<String, Sala> salas) {
        String idSala = InOut.leString("Informe o Id da sala: ");
        String numAssentos = InOut.leString("Informe o número de assentos da sala: ");
        String tipoTela = InOut.leString("Informe o tipo de tela (2D, 3D, XD ou Platinum): ");
        String localizacao = InOut.leString("Informe a localização da sala: ");
        int numSessoes = InOut.leInt("Quantas sessões há na sala de ID " + idSala + "?");

        Sala novaSala = new Sala(idSala, numAssentos, tipoTela, localizacao);
        for (int i = 0; i < numSessoes; i++) {
            cadastrarSessao(novaSala);
        }

        salas.put(idSala, novaSala);
    }

    public static void cadastrarSessao(Sala sala) {
        String horarioSessao = InOut.leString("Informe o Horário da Sessão: ");
        cadastrarFilme(sala, horarioSessao);
    }

    public static void cadastrarFilme(Sala sala, String horarioSessao) {
    String nomeFilme = InOut.leString("Informe o Nome do Filme: ");
    int idFilme = InOut.leInt("Informe o ID do Filme: ");
    String generoFilme = InOut.leString("Informe o Gênero do Filme: ");
    long duracaoFilme = InOut.leLong("Informe a duração do filme (em minutos): ");
 

    Filme filme = new Filme(idFilme, nomeFilme, duracaoFilme, generoFilme);
    int numAtores = InOut.leInt("Quantos atores estão no filme?");

    for (int i = 0; i < numAtores; i++) {
        String nomeAtor = InOut.leString("Informe o Nome do " + (i + 1) + "º Ator: ");
        int idAtor = InOut.leInt("Informe o ID do Ator: ");
        String papelAtor = InOut.leString("Informe o Papel do Ator: ");
        Ator ator = new Ator(idAtor, nomeAtor, papelAtor);
        filme.adicionarAtor(ator);
    }

    Sessao sessao = new Sessao("Ativa", horarioSessao);
    sessao.adicionarFilme(filme);
    sala.adicionarSessao(sessao);
}



    public static void visualizarSalas(Map<String, Sala> salas) {
    StringBuilder output = new StringBuilder("Salas Cadastradas:\n");
    for (Sala sala : salas.values()) {
        output.append("ID da Sala: ").append(sala.getIdentificador()).append("\n");
        output.append("Localização: ").append(sala.getLocalizacao()).append("\n");
        output.append("Número de Assentos: ").append(sala.getNumeroAssentos()).append("\n");
        output.append("Tipo de Tela: ").append(sala.getTipoTela()).append("\n");

        for (Sessao sessao : sala.getListaSessoes().values()) {
            output.append("\nSessão: ").append(sessao.getHorario()).append("\n");

            for (Filme filme : sessao.getListaFilmes().values()) {
                output.append("\tFilme: ").append(filme.getTitulo()).append("\n");
                output.append("\tID do Filme: ").append(filme.getIdFilme()).append("\n");
                output.append("\tGênero: ").append(filme.getGenero()).append("\n");
                output.append("\tDuração: ").append(filme.getDuracao()).append(" minutos\n");
                output.append("\tAtores: \n");
                for (Ator ator : filme.getAtores()) {
                    output.append("\t\t- Nome do Ator: ").append(ator.getNome()).append("\n");
                    output.append("\t\t  ID do Ator: ").append(ator.getIdAtor()).append("\n");
                    output.append("\t\t  Papel do Ator: ").append(ator.getPapel()).append("\n");
                }
            }
        }
        output.append("\n");
    }
    InOut.MsgDeInformacao("UVV FLIX", output.toString());
}
}

