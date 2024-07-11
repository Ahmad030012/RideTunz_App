import java.util.Scanner;

public class Tasbeeh 
{
    public void Counter()
    {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int lastCount = 0;

        System.out.println("Press 'Enter' to increment the counter, 'r' to reset, or 'e' to exit: ");
        while (true) 
        {
            String input = scan.nextLine();
            
            if (input.isEmpty()) 
            {
                counter++;
                System.out.printf("\rCounter value: %d", counter);
            } 
            else if (input.equals("r")) 
            {
                counter = 0;
                System.out.println("Counter reset.");
                System.out.printf("Counter value: %d", counter);
            } 
            else if (input.equals("e")) 
            {
                lastCount = counter;
                break;
            } 
            else 
            {}
        }
        System.out.printf("Last counter value: %d%n", lastCount);
    }
}
