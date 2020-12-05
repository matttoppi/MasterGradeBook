import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class subjectCreation {
    /**
     * creates a subject
     * creates a text file that is put into the project directory
     * asks user for weights of exams, quizzes, homeworks, projects... all in percent values
     *      weights are printed in text file header for later use
     * has system making sure user typed in the correct class name (if...else)
     *
     *
     * @throws IOException
     * @throws InterruptedException
     */

    public subjectCreation() throws IOException, InterruptedException {

        double[] weightedArray = new double[0];
        
        for (int i = 1; i <= 1; ) {
            System.out.print("What is the name of the new subject you would like to create?: ");
            Scanner nameOfNewSubject = new Scanner(System.in);
            String subject = nameOfNewSubject.nextLine();

            System.out.print("Please re-type subject name: ");
            Scanner nameOfNewSubject2 = new Scanner(System.in);
            String subject2 = nameOfNewSubject2.nextLine();


            // Checks to see if password is needed. If yes then has user set a password
            boolean needPassword = true; // REMOVE THIS LINE AFTER YOU SET UP TXT DOCUMENT
            String firstPassword = null;
            String secondPassword = null;


            for (int j = 1; j <= 1; ) {


                System.out.println("---------------------------------------------------------------");
                System.out.print("Please create a password to use in the future (case sensitive): ");
                Scanner userPassword = new Scanner(System.in);
                firstPassword = userPassword.nextLine();

                //prompts user to re-enter the password to clarify there was no typo's
                System.out.print("Please re-enter the password: ");
                Scanner userPassword2 = new Scanner(System.in);
                secondPassword = userPassword2.nextLine();

                if (firstPassword.equals(secondPassword)) {
                    System.out.println("|Password settings updated|");
                    System.out.println("|Please write this down along to be used later|");
                    j++;
                } else {
                    System.out.println("             |YOUR PASSWORDS DID NOT MATCH|");
                    System.out.println("                   |PLEASE TRY AGAIN|");
                }
            }//-------------------------------------------------------------------------

            if (subject2.equals(subject)) {
                //asks for the weights of each grade category
                System.out.println("Enter the weight of each of the following assignment types to later be calculated into a final grade: ");
                System.out.println("Each weight is out of 100\n");
                for (int weightCount = 1; weightCount <= 1; ) {
                    Scanner weight = new Scanner(System.in);
                    System.out.print("Exams: ");
                    double exam = weight.nextDouble();
                    System.out.print("Quizzes: ");
                    double quiz = weight.nextDouble();
                    System.out.print("Homework: ");
                    double homework = weight.nextDouble();
                    System.out.print("Projects: ");
                    double project = weight.nextDouble();

                    double checkingTotalWeight = exam + quiz + homework + project;

                    if (checkingTotalWeight == 100.00) {
                        weightedArray = new double[]{exam, quiz, homework, project};
                        weightCount++;
                    } else {
                        System.out.println("Your weights do not add up to 100%");
                        System.out.println("Make sure that the number you are entering is out of 100\n");
                    }
                }
            
                String pathwrite = "C:\\Users\\mattt\\OneDrive - Florida Gulf Coast University\\School\\Programming\\JAVA (COP2006)\\gradebook_java_class_final\\Grade_Book_Alpha_Code-master\\" + subject + ".txt";
                File f = null;
                boolean bool = false;
                BufferedWriter out = null;

                try {
                    //where files get output
                    //sets the format of the lines so that they can be accessed similarly in the other methods
                    FileWriter write = new FileWriter(pathwrite, true);
                    out = new BufferedWriter(write);
                    out.write(firstPassword + "\n");
                    out.write(weightedArray[0] + "," + weightedArray [1] +"," + weightedArray[2] + "," + weightedArray [3] + "\n");
                    System.out.println("Grade Weights have been saved\n");
                    new pauseForXAmountOfTime();
                    System.out.println("Subject has been created\n");

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (out != null)
                        out.close();

                }
                i++;
            }else{
                //forces user to input the correct class name
                System.out.println("             |YOUR SUBJECT NAMES DID NOT MATCH|");
                System.out.println("                   |PLEASE TRY AGAIN|");
            }
        }
        new pauseForXAmountOfTime(); // calls the class that will make the program wait before parsing the next line
        new enterToContinue();
        new mainMenuUI(); // calls the main menu interface... only way to stop the program currently is to do so in the
        // main menu
    }
}
