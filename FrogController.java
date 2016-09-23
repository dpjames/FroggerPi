public class FrogController{
   private FrogView view;
   private FrogModel model;
   public FrogController(){
      model = new FrogModel();
      view = new FrogView(model);
   }
   public void start(){
      System.out.println("frog");
      while(true){
         view.render();      
      }
   }
}
