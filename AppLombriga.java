package mc322.lab3;
public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      tk.gravaPasso("=====");
      tk.gravaPasso("##O@@@##");
      tk.gravaPasso("#O@@@###");
      tk.gravaPasso("#O@@@@##");
      tk.gravaPasso("O@@@@###");
      tk.gravaPasso("@@@@O###");
      tk.gravaPasso("#@@@@O##");
      
      tk.stop();
   }

}
