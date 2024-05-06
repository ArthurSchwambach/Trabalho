package EarthWar;

public
class Guerreiro {
private
  String nome;
private
  int quantidadeVidas;

public
  Guerreiro(String nome) { this.nome = nome; }

public
  Guerreiro(String nome, int quantidadeVidas) {
    this.nome = nome;
    this.quantidadeVidas = quantidadeVidas;
  }

public
  String pedirVidaExtra() {
    String VidaExtraComInput = InOut.VidaExtraComInput("Peça uma vida extra!");
    
    return VidaExtraComInput;
  }

public
  String getNome() { return nome; }

public
  void setNome(String nome) { this.nome = nome; }

public
  int getQuantidadeVidas() { return quantidadeVidas; }

public
  void setQuantidadeVidas(int quantidadeVidas) {
    this.quantidadeVidas = quantidadeVidas;
  }
}
