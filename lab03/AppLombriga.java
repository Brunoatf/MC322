package mc322.lab3;
public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      Animacao animacao = new Animacao("080403MCMVM");
      tk.gravaPasso("=====");
      for (int i=0; i<animacao.arrayDeAnimacao.length - 6; i++) {
    	  tk.gravaPasso(animacao.apresenta());
    	  animacao.passo();
      }
      tk.gravaPasso(animacao.apresenta());
      
      tk.stop();
   }

}
