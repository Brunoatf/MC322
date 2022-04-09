package pt.c02oo.s03relacionamento.s04restaum;

public class peca {

	char tipo; 
	//casas vazias do tabuleiro foram consideradas como pecas de tipo '-'
	//casas preenchidas com pecas padrao foram consideradas como pecas de tipo 'P'
	//posicoes de fora do tabuleiro foram consideradas como pecas de tipo ' '
	
	peca (char tipo) {
		this.tipo = tipo;
	}
	
	void atualizarEstado() { //atualiza o estado da peca, que pode variar entre uma peca padrao e um espaco vazio
		if (tipo == 'P') {
			tipo = '-';
		}
		else {
			tipo = 'P';
		}
	}

}
