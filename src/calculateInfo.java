import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class calculateInfo {
    /**
     * calculates the weights and averages of the grades
     *
     */

    public calculateInfo(){

        // using the subject matt for now as place holder

        String pathread = "C:\\Users\\Matt Toppi\\OneDrive - Florida Gulf Coast University\\School\\Programming\\JAVA (COP2006)\\gradebook_java_class\\matt.txt";
        String line = "";
        System.out.println(pathread);



        {
            line = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader(pathread));

                System.out.println("Assignment:           Score:");
                while (((line = br.readLine()) != null)) {
                    String[] subject = line.split(",");

                    System.out.println(subject[1]);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}