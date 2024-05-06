package EarthWar;

import java.util.Random;

public
class Oraculo {
private
  String nomeOraculo;
public
  Guerreiro guerreiro;
private
  Random random;

public
  Oraculo() { random = new Random(); }

public
  void definirNome() {
    nomeOraculo = InOut.leString("Informe o nome do Oráculo: ");
  }

public
  void definirNomeGuerreiro() {
    String nomeGuerreiro = InOut.leString("Informe o nome do Guerreiro(a): ");
    guerreiro = new Guerreiro(nomeGuerreiro);
  }

public
  void sortearVidas() { guerreiro.setQuantidadeVidas(random.nextInt(4) + 9); }

public
  int gerarSegredo() {
    int segredo = random.nextInt(100) + 1;
    return segredo;
  }

  
public boolean nivel1() {
    int segredo = gerarSegredo();
    int vidas = guerreiro.getQuantidadeVidas();
    int palpite;
    boolean vidaExtra = true;
    while (vidas > 0) {
        palpite = InOut.leInt("Digite um palpite ou digite -1 para sair do jogo: ");
        
        if (palpite == -1) {
           return false;
        }
        
        if (palpite == segredo) {
            InOut.MsgDeInformacao("Correto!", "Você acertou!");
            guerreiro.setQuantidadeVidas(vidas);
            return true;
        } else if (palpite < segredo) {
            InOut.maior("Errado!");
            InOut.MsgDeErro(
                "Errado!", "Você ainda tem " +
                        (vidas - 1) + " vidas!");
        } else if (palpite > segredo) {
            InOut.menor("Errado!");
            InOut.MsgDeErro(
                "Errado!", "Você ainda tem " +
                        (vidas - 1) + " vidas!");
        }
        vidas--;
        guerreiro.setQuantidadeVidas(vidas);

        if (vidas == 0 && vidaExtra) {
            vidaExtra = decidirVidaExtra(guerreiro.pedirVidaExtra());
            if (vidaExtra) {
                vidas++;
                vidaExtra = false;
            } else {
                return false;
            }
        }
    }
    return false;
}


public
  boolean nivel2() {
    int vidas = guerreiro.getQuantidadeVidas();
    boolean vidaExtra = true;
    while (vidas > 0) {
      String opcao = InOut.leString("Informe - PAR OU IMPAR: ");
      int warrior = random.nextInt(6);
      int oracle = random.nextInt(6);
      int soma = warrior + oracle;
      if ((soma % 2 == 0 && opcao.equalsIgnoreCase("PAR")) ||
          (soma % 2 != 0 && opcao.equalsIgnoreCase("IMPAR"))) {
        InOut.MsgDeInformacao("Correto!", "Você ganhou o jogo!");
        guerreiro.setQuantidadeVidas(vidas);
        return true;
      } else {
        InOut.MsgDeErro("Errado!", "Perdeu esta rodada!!");
      }
      vidas--;
      guerreiro.setQuantidadeVidas(vidas);
      if (vidas == 0 && vidaExtra) {
        vidaExtra = decidirVidaExtra(guerreiro.pedirVidaExtra());
        if (vidaExtra) {
          vidas++;
          vidaExtra = false;
        } else {
          return false;
        }
      }
    }
    return false;
  }

public
  boolean decidirVidaExtra(String misericordia) {
    boolean vidaExtra = misericordia.split("\\s+").length > 5;
    if (vidaExtra) {
      guerreiro.setQuantidadeVidas(1);
      InOut.RecebeVidaExtra("Você recebeu uma vida extra!");
      return true;
    } else {
      InOut.SemVidaExtra("Você não recebeu uma vida extra...");
      return false;
    }
  }

public String apresentacao() {
    return "Guerreiro(a) " + guerreiro.getNome() +
                    
           ", um meteoro irá cair em seu planeta! Você pedirá ajuda ao Oráculo " + nomeOraculo + ", o único capaz de criar uma barreira protetora ao redor do mundo.\n" +
           "Só há um problema: O Oráculo " + nomeOraculo + " é DOIDO e só ajuda aqueles que ganham seus jogos.\n" +
            "Você tem " + guerreiro.getQuantidadeVidas() + " vidas.\n\n" +
           "Boa sorte, Guerreiro(a) " + guerreiro.getNome() + "!";
}


}

