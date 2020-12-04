import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class csvReader {
    /**
     * Accesses the text file assosiated with the subject name that the user inputs
     * Prints out the values from .txt file on to the console
     *
     */

    public csvReader() {
        System.out.println("Which class would you like to view?");
        Scanner requestedSubject = new Scanner(System.in);
        String subjectRequester = requestedSubject.nextLine();

        //sets a string the the file path which is later easily called
        String pathread = "C:\\Users\\mattt\\OneDrive - Florida Gulf Coast University\\School\\Programming\\JAVA (COP2006)\\gradebook_java_class_final\\Grade_Book_Alpha_Code-master\\"+ subjectRequester + ".txt";
        String line = "";
        System.out.println(pathread);

        //fetching mechanism for needed .txt
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(pathread));

                //HOW DO I FORMAT THIS PRINT STATEMENT SO EVERYTHING ALIGNS I AM GETTING AND ERROR
                System.out.println("Assignment:           Score:");
                while (((line = br.readLine()) != null)) { //while line in .txt has characters
                    String[] assignmentInfo = line.split(","); //put the columns into an array
                    System.out.print(assignmentInfo[0] + " " +  assignmentInfo[1] + " " +  assignmentInfo[2] + " " +  assignmentInfo[3]); //print arrays
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

