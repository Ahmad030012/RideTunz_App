import java.util.ArrayList;
import java.util.Arrays;

public class Driver    
{
    private String Name;
    private String PlateNo;
    private String Color;

    ArrayList<String> Names= new ArrayList<String>(Arrays.asList("Ali","Amjad","Irfan","Nadeem","Azhar","Junaid","Jafri"));
    ArrayList<String> Plates=new ArrayList<String>(Arrays.asList("12-LEU","22-KW","46-BR","90-BT","86-JEI","44-PLK"));
    ArrayList<String> Colors=new ArrayList<String>(Arrays.asList("Sky","Blue","White","Grey","Black","Red"));

    public void Driver()
    {
        int nameIndex = (int) (Math.random() * Names.size());
        int plateIndex = (int) (Math.random() * Plates.size());
        int colorIndex = (int) (Math.random() * Colors.size());
    
        this.Name = Names.get(nameIndex);
        this.PlateNo = Plates.get(plateIndex);
        this.Color = Colors.get(colorIndex);
    }
    
    public Driver()
    {
        int nameIndex = (int) (Math.random() * Names.size());
        int plateIndex = (int) (Math.random() * Plates.size());
        int colorIndex = (int) (Math.random() * Colors.size());
    
        this.Name = Names.get(nameIndex);
        this.PlateNo = Plates.get(plateIndex);
        this.Color = Colors.get(colorIndex);
    }
    public String getColor() 
    {
        return Color;
    }
    public String getPlateNo() 
    {
        return PlateNo;
    }
    public String getName() 
    {
        return Name;
    }
}
