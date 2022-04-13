package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {

	private Peca[][] pecas = new Peca[7][7]; //o tabuleiro sera armazenado como uma matriz de objetos peca, que podem representar pecas, espacos vazios e casas de fora do tabuleiro
	private String ultimoMovimento = null; //guarda a string do ultimo movimento executado sobre o tabuleiro
	
	public Tabuleiro () {
		char[][] referenciaCasas = { //usaremos essa matriz de chars para construir a matriz de objetos peca 
				{' ', ' ', 'P', 'P', 'P', ' ', ' '},
				{' ', ' ', 'P', 'P', 'P', ' ', ' '},
				{'P', 'P', 'P', 'P', 'P', 'P', 'P'},
				{'P', 'P', 'P', '-', 'P', 'P', 'P'},
				{'P', 'P', 'P', 'P', 'P', 'P', 'P'},
				{' ', ' ', 'P', 'P', 'P', ' ', ' '},
				{' ', ' ', 'P', 'P', 'P', ' ', ' '}
		};
		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				if (referenciaCasas[i][j] == 'P') {
					pecas[i][j] = new Peca('P');
				}
				else if (referenciaCasas[i][j] == '-') {
					pecas[i][j] = new Peca('-');
				}
				else {
					pecas[i][j] = new Peca(' ');
				}
			}
		}
	}
	
	public String tituloUltimoMovimento () {
		return "source: "+ultimoMovimento.substring(0, 2)+"; target:"+ultimoMovimento.substring(3);
	}

	public char[][] estadoAtualTabuleiro() {
		char[][] board = new char[7][7];
		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				board[i][j] = pecas[i][j].getTipo();
			}
		}
		return board;
	}
	
	private int traduzirCoordenadas(char caractere) {
		return switch (caractere) {
			case 'a' -> 0;
			case 'b' -> 1;
			case 'c' -> 2;
			case 'd' -> 3;
			case 'e' -> 4;
			case 'f' -> 5;
			case 'g' -> 6;
			default -> -1;
		};
	}

	private boolean movimentoPossivel(int linhaTarget, int colunaTarget, int linhaSource, int colunaSource) {
		if (linhaSource > 0 && linhaSource < 7 && colunaSource > 0 && colunaSource < 7 && linhaTarget > 0 && linhaTarget < 7 && colunaTarget > 0 && colunaTarget < 7) {
			if (pecas[linhaTarget][colunaTarget].getTipo() == '-' && pecas[linhaSource][colunaSource].getTipo() == 'P' ) {
				if (linhaSource == linhaTarget) {
					if (Math.abs(colunaTarget - colunaSource) == 2 && pecas[linhaTarget][(colunaTarget + colunaSource) / 2].getTipo() == 'P') {
						return true;
					}
				}
				else if (colunaSource == colunaTarget) {
					if (Math.abs(linhaTarget - linhaSource) == 2 && pecas[(linhaTarget + linhaSource) / 2][colunaTarget].getTipo() == 'P') {
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	public void executarMovimento (String posicoes) {

		int linhaTarget = Integer.parseInt(posicoes.substring(4, 5)) - 1;
		int linhaSource = Integer.parseInt(posicoes.substring(1, 2)) - 1;
		int colunaSource = traduzirCoordenadas(posicoes.charAt(0));
		int colunaTarget = traduzirCoordenadas(posicoes.charAt(3));

		if (movimentoPossivel(linhaTarget, colunaTarget, linhaSource, colunaSource)) {
			pecas[(linhaTarget + linhaSource) / 2][(colunaTarget + colunaSource) / 2].atualizarEstado();
			pecas[linhaTarget][colunaTarget].atualizarEstado();
			pecas[linhaSource][colunaSource].atualizarEstado();
			ultimoMovimento = posicoes;
		}
		
	}
 }
