package EarthWar;

public
class Earthwar {
public
  static void main(String[] args) {
    InOut.Capa("Earth's War");
    InOut.Introducao("Introdução");
    Oraculo oraculo = new Oraculo();
    oraculo.definirNome();
    oraculo.definirNomeGuerreiro();
    oraculo.sortearVidas();
    
    InOut.MsgDeInformacao("Apresentações", oraculo.apresentacao());

    boolean vitoria1, vitoria2;
    vitoria1 = oraculo.nivel1();

    if (vitoria1 && oraculo.guerreiro.getQuantidadeVidas() > 0) {
      InOut.MsgDeInformacao("Próximo nível",
                            "Próximo nível!\n Máximo de vidas: " +
                                oraculo.guerreiro.getQuantidadeVidas() +
                                " vidas!");
      vitoria2 = oraculo.nivel2();
    } else {
      vitoria2 = false;
    }

    if (vitoria1 && vitoria2) {
        InOut.Vitoria("Fim de Jogo! Parabéns!");
        
    } else {
      InOut.Derrota("Fim de Jogo!");
    }
  }
}