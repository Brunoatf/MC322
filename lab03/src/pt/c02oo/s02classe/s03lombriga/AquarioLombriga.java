package pt.c02oo.s02classe.s03lombriga;
public class AquarioLombriga {
	
	int tamanhoAquario, tamanhoLombriga, posicao;
	String direcao;
	
	public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posInicial) {
		if (tamanhoAquario < 0) { //se o aquario tiver um tamanho negativo
			this.tamanhoAquario = 1; //ele recebera tamanho 1 como padrao
		}
		else {
			this.tamanhoAquario = tamanhoAquario;
		}
		if (tamanhoLombriga > tamanhoAquario || tamanhoLombriga < 0) { //se a lombriga receber um tamanho negativo ou maior que o do aquario
			this.tamanhoLombriga = 1; //ela recebera tamanho 1 por padrao
		}
		else {
			this.tamanhoLombriga = tamanhoLombriga;
		}
		if (posInicial < 1 || posInicial > tamanhoAquario) { //se a posicao inicial estiver fora do esperado
			this.posicao = 1; //ela recebera um valor padrao de 1
		}
		else {
			this.posicao = posInicial;
		}
		this.direcao = "esquerda";
	}
	
	void crescer() {
		if (this.direcao == "esquerda" && this.posicao + this.tamanhoLombriga - 1 < this.tamanhoAquario) {
			this.tamanhoLombriga++;
		}
		else if (this.direcao == "direita" && this.posicao - this.tamanhoLombriga + 1 > 0) {
			this.tamanhoLombriga++;
		}
	}
	
	void virar () {
		if (this.direcao == "esquerda") {
			this.posicao += this.tamanhoLombriga - 1;
			this.direcao = "direita";
		}
		else {
			this.posicao -= this.tamanhoLombriga - 1;
			this.direcao = "esquerda";
		}
	}
	
	void mover () {
		if (this.posicao == this.tamanhoAquario || this.posicao == 1) {
			virar();
		}
		if (this.direcao == "esquerda") {
			this.posicao--;
		}
		else {
			this.posicao++;
		}
	}
}