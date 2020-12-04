import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mainMenuUI {
    /**
     * this class is the first thing called which allows users to seamlessly navigate through the program
     * asks for which class to call
     * adding subject, adding grade, viewing grade, etc.
     *
     * @throws IOException
     * @throws InterruptedException
     */

    public mainMenuUI() throws IOException, InterruptedException {

        //new calculateInfo();

        String requestActionMainMenu = null; //sets the variable to null so that on later uses of the method the
                                             // compiler will not assume that the variable is the same as before


        System.out.println("                   -Student Grade Book-");
        System.out.println("What would you like to do?");
        System.out.println("| Add subject | Add grade | View grade | (type exit to close application)");
        Scanner scan = new Scanner(System.in);
        requestActionMainMenu = scan.nextLine();
        requestActionMainMenu = requestActionMainMenu.toLowerCase(); //converts user input to lowercase for easy switch

        //switch statement calling other classes based off user input
        switch (requestActionMainMenu) {
            case "add subject":
                new subjectCreation();
            case "add class":
                new subjectCreation();
                break;
            case "add grade":
                new csvWriter();
                break;
            case "view grade":
                new csvReader();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }
}