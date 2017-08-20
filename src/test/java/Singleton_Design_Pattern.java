/**
 * Created by acedric on 31/05/2017.
 */
//http://www.javaworld.com/article/2073352/core-java/simply-singleton.html
public class Singleton_Design_Pattern {

    //create an object of SingleObject
    private static Singleton_Design_Pattern instance = null;

    //make the constructor private so that this class cannot be
    //instantiated


    //Get the only object available
    public static Singleton_Design_Pattern getInstance() {
        if (instance == null) {
            instance = new Singleton_Design_Pattern();
        }
        return instance;
    }

    private Singleton_Design_Pattern() {
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        Singleton_Design_Pattern sp = new Singleton_Design_Pattern();
        sp.showMessage();
        sp.showMessage();
    }

}

/*public class ClassicSingleton {
   private static ClassicSingleton instance = null;
   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }
}*/