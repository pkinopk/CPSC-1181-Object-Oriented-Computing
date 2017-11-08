import javax.swing.JFrame;

/**
   This program displays the growth of an investment with variable interest.
*/
public class CalculatorViewer
{  
   public static void main(String[] args)
   {  
      JFrame frame = new CalculatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
