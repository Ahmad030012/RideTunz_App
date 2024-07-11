import java.io.*;
import java.util.*;
public class Test {
    public static Scanner in = new Scanner(System.in);
    public static boolean RideEnd = false;

    public static void main(String[] args) throws InterruptedException {
        User s1 = new User();
        Rating r1 = new Rating();
        Location l1 = new Location();
        Safety sf1 = new Safety();
        Driver d1 = new Driver();
        Fare f1 = new Fare();
        Timer timer = new Timer();
        createUser(s1, sf1);
        LocationAndFare(s1, d1, l1, f1);
        System.out.println("\t\t\tGood Luck on Your Journey!!");
        timerThread(s1, timer);
        while (!RideEnd)
        {
            nMenu(s1);
        }
        System.out.println("\t\t\tRide Finished.\n" + "Payable Fare:\n" + s1.getLocation().getFare().getFinFare());
        Thread.sleep(3000);
        appRate(s1, r1);
        System.out.println("See you Next Time.");
        UserFile(s1,"userData.txt");
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        //for reading data
       /* System.out.println("enter 1 for get data :");
        choice = scanner.nextInt();
        if(choice == 1)
        {
            readData("userData.txt");
        }*/

    }

    public static void createUser(User s1, Safety sf1) {
        s1.setSafety(sf1);
        System.out.println("Enter Your Name:");
        String name = in.nextLine();
        System.out.println("Enter your Ph No:");
        long ph = in.nextLong();
        long em;
        s1.SetInfo(name,ph);
        do {
            System.out.println("Enter Emergency Contact:");
            em = in.nextLong();
            s1.getSafety().setPh_no(em);
        } while (em == ph);
        System.out.println("\t\tProfile Created Successfully!!!\n");
    }

    public static void LocationAndFare(User s1, Driver d1, Location l1, Fare f1) {
        System.out.println("Enter your Current Location:");
        in.nextLine();
        String address = in.nextLine();
        String loc;
        s1.setAddress(address);
        s1.setDriver(d1);
        s1.setLocation(l1);
        do {
            System.out.println("Enter Your Destination:");
            loc = in.nextLine();
            s1.getLocation().setLocation(loc);
        } while (loc.equalsIgnoreCase(address));
        s1.getLocation().setFare(f1);
        System.out.println("Basic Fare:");
        System.out.println(s1.getLocation().getFare().getBaseFare());
        System.out.println("Do you Want to Negotiate Fare(Y/N):");
        String op = in.nextLine();
        if (op.equalsIgnoreCase("Y")) {
            s1.getLocation().getFare().Negotiation();
            System.out.println("Driver has Agreed on the Fare.");
            System.out.println("Final Fare:\n" + s1.getLocation().getFare().getFinFare());
        } else {
            s1.getLocation().getFare().setFinFare(s1.getLocation().getFare().getBaseFare());
            System.out.println("Final Fare:\n" + s1.getLocation().getFare().getFinFare());
        }
        System.out.println("\nDriver Name:\n" + s1.getDriver().getName() + "\nCar Plate No:\n" + s1.getDriver().getPlateNo() + "\nCar Color:\n" + s1.getDriver().getColor());
    }

    public static void timerThread(User s1, Timer timer) {
        s1.getLocation().setTimer(timer);
        Thread timerThread = new Thread(() ->
        {
            try {
                s1.getLocation().getTimer().timerLogic();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            RideEnd = true;
        });
        timerThread.start();
        System.out.println("\n\t\t\tTime Till Destination is Reached:");
        s1.getLocation().getTimer().getTimeRemaining();
    }

    public static void nMenu(User s1) {
        System.out.println("\nMenu:");
        System.out.println("1 For Music.\n2 for Tasbeeh.\n3 to Play TictacToe.\n4 to Play Hangman.\n5 for Safety Options.\n6 for ETA.\n");
        int option;
        switch (option = in.nextInt()) {
            case 1:
                Music m1 = new Music();
                option = 0;
                System.out.println("1 for Default Playlist.\n2 for Custom Playlist.\n3 to Update Default Playlist.");
                option = in.nextInt();
                if (option == 1) {
                    m1.GetDefaultPlaylist();
                    if (RideEnd)
                        break;
                } else if (option == 2) {
                    m1.CreatePlaylist();
                    if (RideEnd)
                        break;
                } else if (option == 3) {
                    m1.GetDefaultPlaylist();
                    m1.UpdatePlayList();
                    if (RideEnd)
                        break;
                } else {
                    System.out.println("Invalid input.");
                }

                break;
            case 2:
                Tasbeeh t1 = new Tasbeeh();
                t1.Counter();
                if (RideEnd)
                    break;
                break;
            case 3:
                Game tictactoeGame = new Game();
                tictactoeGame.Tictactoe();
                if (RideEnd)
                    break;
                break;
            case 4:
                Hangman hman = new Hangman();
                hman.HangmanRun();
                in.nextLine();
                if (RideEnd)
                    break;
                break;
            case 5:
                System.out.println(s1.getSafety().GetQuote());
                System.out.println("1 to Call Police.\n2 to Call Emergency Contact.");
                int opt = in.nextInt();
                if (opt == 1) {
                    System.out.println("Police No:\n" + s1.getSafety().getPolice());
                    if (RideEnd)
                        break;
                } else if (opt == 2) {
                    System.out.println("Emergency Contact:\n" + s1.getSafety().getPh_no());
                    if (RideEnd)
                        break;
                }
                break;
            case 6:
                System.out.println("Time Remaining:");
                s1.getLocation().getTimer().getTimeRemaining();
                if (RideEnd)
                    break;
                break;
            default:
                System.out.println("Invalid option selected.");
                if (RideEnd)
                    break;
                break;
        }

    }

    public static void appRate(User s1, Rating r1) {
        s1.setRating(r1);
        System.out.println("Rate the App(1 to 5 Stars):");
        int stars = in.nextInt();
        s1.getRating().setStars(stars);
        in.nextLine();
        System.out.println("Comments:");
        String comm = in.nextLine();
        s1.getRating().setComments(comm);
        System.out.println("Thanks for Your Feedback!!");
    }
    public static void UserFile(User user, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n"+"Name: " + user.getName()+"\n");
            bufferedWriter.write("Phone Number: " + user.getPh_no()+"\n");
            bufferedWriter.write("Emergency Contact: " + user.getSafety().getPh_no()+"\n");
            bufferedWriter.write("Address: " + user.getAddress()+"\n");
            bufferedWriter.write("Destination: " + user.getLocation().getLocation()+"\n");
            bufferedWriter.write("Driver Name: " + user.getDriver().getName()+"\n");
            bufferedWriter.write("Car Color: " + user.getDriver().getColor()+"\n");
            bufferedWriter.write("Car Number: " + user.getDriver().getPlateNo()+"\n");
            bufferedWriter.write("Fare: " + user.getLocation().getFare().getFinFare()+"\n");
            bufferedWriter.write("Rating:(1 to 5): " + user.getRating().getStars()+"\n");

            bufferedWriter.close();
        } catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void readData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text;
            int count = 0;
            System.out.println("Ride Data:");
            while ((text = reader.readLine()) != null) {
                if (text.equals("")) {
                    count++;
                    System.out.println("\nRide " + count + ":");
                } else {
                    System.out.println(text);
                }
            }
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }
}