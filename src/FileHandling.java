import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling
{
    public static void userStoreDat(String name,User s1)
    {
        try
        {
            FileWriter writer = new FileWriter(name,true);
            writer.write("\nName: "+s1.getName()+"\n");
            writer.write("Phone Number: "+s1.getPh_no()+"\n");
            writer.write("Address: "+s1.getAddress()+"\n");
            writer.write("Emergency Contact: "+s1.getSafety().getPh_no());
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void musicStoreDat(String name,Music m1,User s1)
    {
        try
        {
            FileWriter writer=new FileWriter(name,true);
            writer.write("\nPlaylist of "+s1.getName()+":\n");
            for(String a:m1.getCustomPlaylist())
            {
                writer.write(a+"\n");
            }
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void rideStoreDat(String name,User s1)
    {
        try
        {
          FileWriter writer =new FileWriter(name);
          writer.write("\nName: "+s1.getName()+"\n");
          writer.write("Destination: "+s1.getLocation().getLocation()+"\n");
          writer.write("Fare: "+s1.getLocation().getFare().getFinFare()+"\n");
          writer.write("Driver Name: "+s1.getDriver().getName()+"\n");
          writer.write("Car Plate: "+s1.getDriver().getPlateNo()+"\n");
          writer.write("Car Color: "+s1.getDriver().getColor()+"\n");
          writer.write("User Ride Rating (in Stars): "+s1.getRating().getStars()+"\n");
          writer.write("User Ride Comments: "+s1.getRating().getComments()+"\n");
          writer.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
