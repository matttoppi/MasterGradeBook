import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class csvReader {
    /**
     * Accesses the text file assosiated with the subject name that the user inputs
     * Prints out the values from .txt file on to the console
     */

    public csvReader() throws IOException, InterruptedException {
        System.out.println("Which class would you like to view?");
        Scanner requestedSubject = new Scanner(System.in);
        String subjectRequester = requestedSubject.nextLine();

        System.out.println("What is the name of the student you want to view?");
        Scanner studentName = new Scanner(System.in);
        String nameOfStudent = studentName.nextLine();

        //sets a string the the file path which is later easily called
        String pathread = "C:\\Users\\mattt\\OneDrive - Florida Gulf Coast University\\School\\Programming\\JAVA (COP2006)\\gradebook_java_class_final\\Grade_Book_Alpha_Code-master\\" + subjectRequester + ".txt";
        String line = "";
        System.out.println(pathread);

        double examTotal = 0;
        double examTotalCount = 0;
        double quizTotal = 0;
        double quizTotalCount = 0;
        double homeWorkTotal = 0;
        double homeWorkTotalCount = 0;
        double projectTotal = 0;
        double projectTotalCount = 0;

        String[] weightsFromText = null;
        //fetching mechanism for needed .txt
            try {
                BufferedReader br = new BufferedReader(new FileReader(pathread));
                line = br.readLine();
                line = br.readLine();
                weightsFromText = line.split(","); //put the columns into an array

                System.out.println("\nSTUDENT: " + nameOfStudent);
                System.out.printf("%s %19s %20s","GRADE", "NAME", "TYPE\n");
                System.out.println("-");

                while (((line = br.readLine()) != null)) { //while line in .txt has characters
                    String[] assignmentInfo = line.split(","); //put the columns into an array
                    HashMap<String, String> assignmentInformation = new HashMap<>();
                    assignmentInformation.put("assignName", assignmentInfo[0]);
                    assignmentInformation.put("assignGrade", assignmentInfo[1]);
                    assignmentInformation.put("assignType", assignmentInfo[2]);

                    String assignmentTypeString = null;


                    //sorts the grades into categories to later be calculated
                    //prints out the information for each assignment
                    if (assignmentInformation.get("assignType").equals("1")) {
                        assignmentTypeString = "Exam";
                        System.out.printf("%s%% %20s %20s",assignmentInformation.get("assignGrade"), assignmentInformation.get("assignName"), assignmentTypeString);
                        examTotal = (Integer.parseInt(assignmentInformation.get("assignGrade")) + examTotal);
                        System.out.println();
                        examTotalCount++;
                    }
                    if (assignmentInformation.get("assignType").equals("2")) {
                        assignmentTypeString = "Quiz";
                        System.out.printf("%s%% %20s %20s",assignmentInformation.get("assignGrade"), assignmentInformation.get("assignName"), assignmentTypeString);
                        quizTotal = (Integer.parseInt(assignmentInformation.get("assignGrade")) + quizTotal);
                        System.out.println();
                        quizTotalCount++;
                    }
                    if (assignmentInformation.get("assignType").equals("3")) {
                        assignmentTypeString = "Homework";
                        System.out.printf("%s%% %20s %20s",assignmentInformation.get("assignGrade"), assignmentInformation.get("assignName"), assignmentTypeString);
                        homeWorkTotal = (Integer.parseInt(assignmentInformation.get("assignGrade")) + homeWorkTotal);
                        System.out.println();
                        homeWorkTotalCount++;
                    }
                    if (assignmentInformation.get("assignType").equals("4")) {
                        assignmentTypeString = "Project";
                        System.out.printf("%s%% %20s %20s",assignmentInformation.get("assignGrade"), assignmentInformation.get("assignName"), assignmentTypeString);
                        projectTotal = (Integer.parseInt(assignmentInformation.get("assignGrade")) + projectTotal);
                        System.out.println();
                        projectTotalCount++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("\n");
            new enterToNext();

            double examAverage = 0;
            double quizAverage = 0;
            double homeWorkAverage = 0;
            double projectAverage = 0;

            //calculating teh weight of each category
        double weightOfExam = (Double.parseDouble(weightsFromText[0]) / 100);
        double weightOfQuiz = (Double.parseDouble(weightsFromText[1]) / 100);
        double weightOfHomework = (Double.parseDouble(weightsFromText[2]) / 100);
        double weightOfProject = (Double.parseDouble(weightsFromText[3]) / 100);
        double finalGrade = 0;

        System.out.printf("\n\n%22s %20s %18s", "AVERAGES ", "WEIGHT ", "#COUNT");
            if (examTotal != 0) {
                examAverage = examTotal / examTotalCount;
                System.out.printf("\n\nEXAM: %13.2f%% %20s%% %18.0f ", examAverage, weightsFromText[0], examTotalCount);
            }
            if (quizTotal != 0) {
                quizAverage = quizTotal / quizTotalCount;
                System.out.printf("\n\nQUIZ: %13.2f%% %20s%% %18.0f ", quizAverage, weightsFromText[1], quizTotalCount);
            }
            if (homeWorkTotal != 0) {
                homeWorkAverage = homeWorkTotal / homeWorkTotalCount;
                System.out.printf("\n\nHOMEWORK: %9.2f%% %20s%% %18.0f ", homeWorkAverage, weightsFromText[2], homeWorkTotalCount);
            }
            if (projectTotal != 0) {
                projectAverage = projectTotal / projectTotalCount;
                System.out.printf("\n\nPROJECT: %10.2f%% %20s%% %18.0f\n\n", projectAverage, weightsFromText[3], projectTotalCount);
            }

            System.out.println("\n-\n");
        String gradeLettered = null;
        finalGrade = (examAverage * weightOfExam) + (quizAverage * weightOfQuiz) + (homeWorkAverage * weightOfHomework) + (projectAverage * weightOfProject);
            System.out.printf("TOTAL: %12.2f%%  \n", finalGrade);

            if (finalGrade < 60) {
                gradeLettered = "F";
            } else if (finalGrade < 70) {
                gradeLettered = "D";
            } else if (finalGrade < 80) {
                gradeLettered = "C";
            } else if (finalGrade < 90) {
                gradeLettered = "B";
            } else if (finalGrade <= 100) {
                gradeLettered = "A";
            }

            System.out.printf("GRADE: %12s \n\n", gradeLettered);

        new enterToContinue();
        new mainMenuUI();
        }



}