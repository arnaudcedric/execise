package exercise;
import java.io.*;
/**
 * Created by acedric on 23/03/2017.
 */
public class Exercise {
    private static Exercise e = new Exercise();
    private Exercise() {
    }
    public static Exercise getE() {
        return e;
    }
    public void dosomething(){
    }

    public static void main(String[] args) throws IOException {

        File f = new File("C:\\Users\\acedric\\Downloads\\ashishmodule7\\firstFile.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter("C:\\Users\\acedric\\Downloads\\ashishmodule7\\firstFile.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("first file created");
        bw.newLine();
        bw.write("second line");
        bw.flush();
        System.out.println("------------------------------");
        FileReader fr = new FileReader("C:\\Users\\acedric\\Downloads\\ashishmodule7\\firstFile.txt");
        BufferedReader br = new BufferedReader(fr);
//        String x = "";
//        while ((x=br.readLine()) != null){
//            System.out.println(x);
//
//        }
    }
}
