import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
public class FrogModel{
   private Frog player;
   private BufferedImage frame;
   public FrogModel(){
      frame = new BufferedImage(480, 320, BufferedImage.TYPE_INT_ARGB);
      player = new Frog();
   }
   public void render(Graphics g){
      player.render();
      g.drawImage(frame, 0, 0, 480, 320, null);
      //might need to clear frame after it is rendered.
   }
   public void move(int x, int y){
      double xper = x/480;
      double yper = y/320;
      if(xper>yper){
         if(xper>.5){
            player.right();
         }else{
            player.left();
         }
      }else{
         if(yper<.5){
            player.up();
         }else {
            player.down();
         }
      }
   }


   private class Frog{
      private int x,y;
      private Frog(){
         x = 0;
         y = 0;
      }
      private void up(){x-=10;}
      private void down(){x+=10;}
      private void left(){y-=10;}
      private void right(){y+=10;}
      private void render(){
         Graphics pen = frame.getGraphics();
         pen.setColor(Color.RED);
         pen.fillRect(x,y,40,40);
      }
   }
}
