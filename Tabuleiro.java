package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	
	char casas[][] = {
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
	      };
	peca pecas[];
	String ultimoMovimento = null;
	
	Tabuleiro () {
		int indice = 0;
		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				if (casas[i][j] == 'P') {
					pecas[indice] = new peca(i, j);
				}
			}
		}
	}
	
	void apresentar () {
		System.out.println("source: "+ultimoMovimento.substring(0, 2)+"; target:"+ultimoMovimento.substring(3));
		for (int i=0; i<7; i++) {
				System.out.println(casas[i]);
		}
	}
	
	int traduzirCoordenadas(char caractere) {
		switch(caractere) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		}
		return -1;
	}
	
	bool movimentoPossivel () {
		
	}
	
	void executarMovimento (String posicoes) {
		int linhaSource = Integer.parseInt(posicoes.substring(1, 1));
		int colunaSource = traduzirCoordenadas(posicoes.charAt(0));
		int colunaTarget = traduzirCoordenadas(posicoes.charAt(3));
		int linhaTarget = Integer.parseInt(posicoes.substring(4, 4));
		
		if (movimentoPossivel(linhaSource, colunaSource, colunaTarget, linhaTarget)) {
			pecas[linhaSource][colunaSource].mover(linhaTarget, colunaTarget);
			ultimoMovimento = posicoes;
		}
		
	}
 }
