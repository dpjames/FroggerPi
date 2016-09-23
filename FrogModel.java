import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
public class FrogModel{
   private Frog player;
   private BufferedImage frame;
   private Graphics pen;
   public FrogModel(){
      frame = new BufferedImage(480, 320, BufferedImage.TYPE_INT_ARGB);
      player = new Frog();
      pen = frame.getGraphics();
   }
   public void render(Graphics g){
      player.render();
      g.drawImage(frame, 0, 0, 480, 320, null);
      //might need to clear frame after it is rendered.
      pen.setColor(Color.WHITE);
      pen.fillRect(0,0,480,320);
   }
   public void move(int x, int y){
      double xper = x/480.0;
      double yper = y/320.0;
      double xperbord = xper;
      double yperbord = yper;
      if(xper > .5){
         xperbord = (480- x) / 480.0;
      } 
      if(yper > .5){
         yperbord = (320 - y) / 320.0;
      }
      System.out.println(xper + " " + yper + " " + xperbord + " " + yperbord);
      if(xperbord<yperbord){
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
      private void up(){y-=10;}
      private void down(){y+=10;}
      private void left(){x-=10;}
      private void right(){x+=10;}
      private void render(){
         pen.setColor(Color.RED);
         pen.fillRect(x,y,40,40);
      }
   }
}
