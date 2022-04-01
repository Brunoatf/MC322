package mc322.lab3;
public class AquarioLombriga {
	
	int tamanhoAquario, tamanhoLombriga, posicao;
	String direcao;
	
	public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posInicial) {
		this.tamanhoAquario = tamanhoAquario;
		this.tamanhoLombriga = tamanhoLombriga;
		this.posicao = posInicial;
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
			this.posicao -= this.tamanhoLombriga + 1;
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