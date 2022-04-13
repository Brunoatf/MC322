package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {

	private char tipo; 
	//casas vazias do tabuleiro foram consideradas como pecas de tipo '-'
	//casas preenchidas com pecas padrao foram consideradas como pecas de tipo 'P'
	//posicoes de fora do tabuleiro foram consideradas como pecas de tipo ' '
	
	public Peca (char tipo) {
		this.tipo = tipo;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public void atualizarEstado() { //atualiza o estado da peca, que pode variar entre uma peca padrao e um espaco vazio
		if (tipo == 'P') {
			tipo = '-';
		}
		else {
			tipo = 'P';
		}
	}

}
