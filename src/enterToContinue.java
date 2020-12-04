public class enterToContinue {
    public enterToContinue()
    {
        System.out.println("---Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception ignored)
        {}
    }
}

