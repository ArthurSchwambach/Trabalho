package iptu2;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
    private List<String> nomeMuni = new ArrayList<>();
    private List<Imovel> imoveis = new ArrayList<>();

    public Municipio() {
        boolean continuar = true;

        while (continuar) {
            int opcao = InOut.leInt(
                    "Escolha uma opção:\n"
                    + "1 - Cadastrar Município\n"
                    + "2 - Visualizar Cadastros Feitos\n"
                    + "3 - Sair"
            );

            if (opcao == 1) {
                cadastrarMunicipio();
            } else if (opcao == 2) {
                visualizarCadastros();
            } else if (opcao == 3) {
                continuar = false;
            } else {
                InOut.MsgDeInformacao("Opção inválida!", "");
            }
        }
    }

    private void cadastrarMunicipio() {
        String nomeMunicipio = InOut.leString("Qual o nome do Município: ");
        nomeMuni.add(nomeMunicipio);

        int numImoveis = InOut.leInt("Quantos imóveis no município " + nomeMunicipio + ": ");
        for (int j = 0; j < numImoveis; j++) {
            Imovel imovel = new Imovel(); // Construtor vazio para permitir a inicialização dos atributos individualmente
            imovel.setNome(imovel.pegarNome());
            imovel.setMeses(imovel.mesesAtraso());
            imovel.setImposto(imovel.imposto());
            imovel.setMulta(calcularMulta(imovel.mesesAtraso(), imovel.getImposto()));
            imoveis.add(imovel);
        }
    }

    public float calcularMulta(int mes, float multa){
        if(mes > 0 && mes <= 5)
        {
            multa += multa * 0.01;
        }
        else if(mes >= 6 && mes <= 8)
        {
            multa += multa * 0.023;
        }
        else if(mes >= 9 && mes <= 10)
        {
            multa += multa * 0.03;
        }
        else if(mes >= 11 && mes <= 12)
        {
            multa += multa * 0.054;
        }
        else if(mes > 12)
        {
            multa += multa * 0.1;
        }
        return multa;
    }

   private void visualizarCadastros() {
    StringBuilder output = new StringBuilder();

    if (nomeMuni.isEmpty()) {
        output.append("Nenhum cadastro realizado ainda.\n");
    } else {
        output.append("Municípios cadastrados:\n");
        for (String municipio : nomeMuni) {
            output.append(municipio).append("\n");
        }
        output.append("Imóveis cadastrados:\n");
        for (Imovel imovel : imoveis) {
            output.append("Nome: ").append(imovel.getNome())
                  .append("\nMeses de Atraso: ").append(imovel.getMeses())
                  .append("\nImposto: ").append(imovel.getImposto())
                  .append("\nMulta: ").append(imovel.getMulta()) // Adicionando o valor da multa
                  .append("\n");
        }
    }

    // Exibe a mensagem de informação com todos os registros concatenados
    InOut.MsgDeInformacao("Listagem", output.toString());
}

}