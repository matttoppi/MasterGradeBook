import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class csvWriter {

    /**
     * a test file for later use
     * <p>
     * IGNORE THIS FILE FOR NOW
     *
     * @throws IOException
     */
    public csvWriter() throws IOException, InterruptedException {
        // hash map with arraylist as my value containing grade and grade weight
        // [key as the name of the assignment] [grade] [grade weight as an integer]

        //asks for class the user wants to view
        System.out.println("Which class would you like to add a grade to? ");
        Scanner requestedSubject = new Scanner(System.in);
        String subjectRequestWrite = requestedSubject.nextLine();

        String pathwrite = "C:\\Users\\mattt\\OneDrive - Florida Gulf Coast University\\School\\Programming\\JAVA (COP2006)\\gradebook_java_class_final\\Grade_Book_Alpha_Code-master\\" + subjectRequestWrite + ".txt";
        String classStoredPassword = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathwrite));
            classStoredPassword = br.readLine();

        } catch (IOException a) {
            a.printStackTrace();

        }


        System.out.println("To add grades to this course you need to be a teacher.");

        for (int n = 1; n <= 3; ) {
            System.out.print("Enter password:");
            Scanner passCheck = new Scanner(System.in);
            String userPasswordChecker = passCheck.nextLine();
            if (!userPasswordChecker.equals(classStoredPassword)) {
                n++;
                int attemptLeft = 4 - n;
                System.out.println("Wrong Password - Try again");
                System.out.println("You have " + attemptLeft + " attempt(s) remaining");

                if (n == 4) {
                    System.out.println("\n\nToo many failed attempts. Exiting application");
                    new pauseForXAmountOfTime();
                    System.exit(0);
                }
            } else {
                System.out.println("Access Granted");
                break;
            }
        }

        for (int i = 1; i <= 1;) {
            String terminate = "no";

            //input for assignment type for weighting
            System.out.println("| Exam | Quiz | Homework | Project |");
            System.out.print("Assignment Type: ");
            Scanner type = new Scanner(System.in);
            String assignmentType = type.nextLine();

            //input for assignment name
            System.out.println("What is the name of the assignment?");
            Scanner assignment = new Scanner(System.in);
            String assignmentName = assignment.nextLine();

            //input for assignment grade
            System.out.println("What is the grade of the assignment?");
            Scanner grade = new Scanner(System.in);
            Integer assignmentGrade = grade.nextInt();


            int assignVal = switch (assignmentType) {
                case "exam" -> 1;
                case "quiz" -> 2;
                case "homework" -> 3;
                case "project" -> 4;
                default -> throw new IllegalStateException("Unexpected value: " + assignmentType);
            };
            //NEED TO GET THE VALUE OF THE ASSIGNMENT TYPE FROM OTHER CLASS AND CONVERT IT INTO A DECIMAL VALUE FOR LATER CALCULATIONS
            //HOW?
            String assignmentString = (assignmentName + "," + assignmentGrade + "," + assignVal + ", " +" \n");

            BufferedWriter out = null;
            try {
                FileWriter write = new FileWriter(pathwrite, true);
                out = new BufferedWriter(write);
                out.write(assignmentString);
                System.out.println("Your grade has been recorded");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null)
                    out.close();

                System.out.println("Would you like to enter another grade?");
                Scanner addMoreGrades = new Scanner(System.in);
                String moreGrades = addMoreGrades.nextLine();
                System.out.println(moreGrades);
                if (moreGrades.equals(terminate)) {
                    i++;
                }
            }
        }
        new enterToContinue();
        new mainMenuUI();
    }
}
