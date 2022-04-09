package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();

      for (String command : commands) System.out.println(command);
      
      char board[][] = {
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
            
      tk.writeBoard("Tabuleiro inicial", board);
      
      Tabuleiro tabuleiroJogo = new Tabuleiro();

      for (String command : commands) { //para cada comando, executaremos um movimento e mostraremos o estado do tabuleiro
         tabuleiroJogo.executarMovimento(command);
         tk.writeBoard(tabuleiroJogo.tituloUltimoMovimento(), tabuleiroJogo.estadoAtualTabuleiro());
      }
      
      tk.stop();
   }

}
