import java.util.Scanner;

public class Fare 
{
    public static Scanner in = new Scanner(System.in);
    private int BaseFare=(int) (Math.random() * 1001) + 1000;
    private int NegFare;
    private int FinFare;

    public int getBaseFare() 
    {
        return BaseFare;
    }
    public void setFinFare(int finFare) 
    {
        FinFare = finFare;
    }
    public int getFinFare() 
    {
        return FinFare;
    }
    public void Negotiation()
    {
        int count=0;
        while(count<3)
        {
          System.out.println("Enter Fare:");
          NegFare=in.nextInt();
          if(NegFare>=BaseFare-100 && NegFare<BaseFare)
          {
            FinFare=NegFare;
            count++;
          }
          else if(NegFare>BaseFare)
          {
            FinFare=NegFare;
            break;
          }
          else
          {}
        }
    }
}    
