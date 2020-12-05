import java.io.IOException;


public class gradebook_java_main {
    /**
     * main method calls the user interface class
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("         |      Welcome to the Student Grade book           |\n         |Teachers will be able to create classes and grades| \n         |     Students will be able to view grades         |\n\n");

        new enterToContinue();
        new mainMenuUI();

    }
}


