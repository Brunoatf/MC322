package pt.c02oo.s02classe.s03lombriga;
public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int i=0; i<lombrigas.length; i++) { //para cada string de animacao em lombrigas[]
    	  Animacao animacao = new Animacao(lombrigas[i]);
          tk.gravaPasso("=====");
          for (int j=0; j<animacao.arrayDeAnimacao.length - 6; j++) { //para cada acao na animacao analisada
        	  tk.gravaPasso(animacao.apresenta());
        	  animacao.passo();
          }
          tk.gravaPasso(animacao.apresenta());
      }
      tk.stop();
   }

}
