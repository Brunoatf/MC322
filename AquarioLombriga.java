package mc322.lab3;
public class AquarioLombriga {
	
	int tamanhoAquario, tamanhoLombriga, posicao;
	String 
	
	AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posInicial) {
		this.tamanhoAquario = tamanhoAquario;
		this.tamanhoLombriga = tamanhoLombriga;
		this.posicao = posInicial;
		this.direcao = 'esquerda'
	}
	
	void crescer() {
		if (this.posicao + this.tamanhoLombriga - 1 < this.tamanhoAquario) {
			this.tamanhoLombriga++;
		}
	}
	
	void virar() {
		this.posicao = 
	}
	
	void mover () {
		if (this.posicao == 1) {
			this.virar()
		}
		else if (this.posicao == this.tamanhoAquario) {
			
		}
		else {
			
		}
	}
}