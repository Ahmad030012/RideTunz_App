import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Music     
{
   public static Scanner in = new Scanner(System.in); 

   private ArrayList<String> CustomPlaylist = new ArrayList<String>();
   private ArrayList<String> DefaultPlaylist = new ArrayList<String>(Arrays.asList("Reverie-Illenium","Playdate-Melanie Martinez","Attention-Charlie Puth","Regard-Raye","Summer High-Ap Dhillon","Tera Chehra-Mitraz"));
  
   public void GetCustomPlaylist()
   {
     System.out.println("Custom Playlist:");
     for(String songs: CustomPlaylist)
     {
        System.out.println(songs);
     }
   }

    public ArrayList<String> getCustomPlaylist() {
        return CustomPlaylist;
    }

    public void UpdatePlayList()
   {
    String input="";
    System.out.println("Enter Song to Add to Playlist(Press -1 to Exit):");
    while(!input.equals("-1"))
    {
     input=in.nextLine();
     if(!input.equals("-1"))
     {
        DefaultPlaylist.add(input);
     }
    }  
   }
   public void CreatePlaylist()
   {
    String input="";
    System.out.println("Enter Song to Add to Playlist(Press -1 to Exit):");
    while(!input.equals("-1"))
    {
     input=in.nextLine();
     if(!input.equals("-1"))
     {
        CustomPlaylist.add(input);
     }
    }  
   }
   public void GetDefaultPlaylist()
   {
    System.out.println("Default Playlist:");
    for(String songs:DefaultPlaylist)
    {
        System.out.println(songs);
    }
   }
}
