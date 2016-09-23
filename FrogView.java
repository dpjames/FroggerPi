import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class FrogView extends JFrame{
   private FrogPanel panel;
   private FrogModel model;
   public FrogView(FrogModel model){
      super();
      this.model = model;
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      panel = new FrogPanel();
      panel.setPreferredSize(new Dimension(480,320));
      add(panel);
      setVisible(true);
      pack();

      addMouseListener(new Controls());
   }
   public void render(){
      panel.repaint();
   }
   private class Controls implements MouseListener{
      @Override
      public void mouseClicked(MouseEvent e){
         model.move(e.getX(), e.getY());
      }
      @Override
      public void mouseEntered(MouseEvent e){

      }
      @Override
      public void mouseExited(MouseEvent e){

      }
      @Override
      public void mousePressed(MouseEvent e){

      }
      @Override
      public void mouseReleased(MouseEvent e){

      }
   }
   private class FrogPanel extends JPanel{
      @Override
      protected void paintComponent(Graphics g){
         super.paintComponent(g);
         model.render(g);
      }
   }

}
