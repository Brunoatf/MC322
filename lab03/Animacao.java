package mc322.lab3;

public class Animacao {
	
	char[] arrayDeAnimacao;
	AquarioLombriga lombriga;
	int numeroPasso; //indica o índice no array de animaçao relativo ao próximo passo da animação
	
	public Animacao(String stringDeAnimacao) {
		this.numeroPasso = 6;
		this.arrayDeAnimacao = stringDeAnimacao.toCharArray();
		int tamanhoAquario = 10 * Character.getNumericValue(this.arrayDeAnimacao[0]) + Character.getNumericValue(this.arrayDeAnimacao[1]);
		int tamanhoLombriga = 10 * Character.getNumericValue(this.arrayDeAnimacao[2]) + Character.getNumericValue(this.arrayDeAnimacao[3]);
		int posInicial = 10 * Character.getNumericValue(this.arrayDeAnimacao[4]) + Character.getNumericValue(this.arrayDeAnimacao[5]);
		this.lombriga = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posInicial);
	}
	
	String apresenta() {
		String saida = "";
		if (lombriga.direcao.equals("direita")) {
			for (int i = 1; i <= lombriga.tamanhoAquario; i++) {
				if (i < lombriga.posicao && i > lombriga.posicao - lombriga.tamanhoLombriga) {
					saida = saida + "@";
				}
				else if (i == lombriga.posicao) {
					saida = saida + "0";
				}
				else {
					saida = saida + "#";
				}
			}
		}
		else {
			for (int i = 1; i <= lombriga.tamanhoAquario; i++) {
				if (i < lombriga.posicao + lombriga.tamanhoLombriga && i > lombriga.posicao) {
					saida = saida + "@";
				}
				else if (i == lombriga.posicao) {
					saida = saida + "0";
				}
				else {
					saida = saida + "#";
				}
			}
		}
		return saida;
	}
	
	void passo() {
		if (arrayDeAnimacao[numeroPasso] == 'M') {
			lombriga.mover();
		}
		else if (arrayDeAnimacao[numeroPasso] == 'C') {
			lombriga.crescer();
		}
		else {
			lombriga.virar();
		}
		numeroPasso++;
	}
	
}