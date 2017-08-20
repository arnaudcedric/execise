import org.testng.annotations.Test;

/**
 * Created by acedric on 30/05/2017.
 */
public class Switch_Statement {

    @Test
    public void test(){
        switchNumbers(2);
    }

    public void switchNumbers(int number){

        switch (number){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println(number + " enter a valid number");

        }
    }
}
