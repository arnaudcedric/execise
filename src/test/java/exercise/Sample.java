package exercise;

/**
 * Created by acedric on 20/04/2017.
 */
public class Sample extends Sample2 {

    private static Sample instance;


    public static Sample getInstance(){
        if (instance == null) {
            instance = new Sample();
        }

        return instance;
    }



    public static void sampleTest_one(){
        System.out.println("Sample is running");

    }

    public static void main(String[] args) {



//        instance.sample_two_test_one();
    }



}
