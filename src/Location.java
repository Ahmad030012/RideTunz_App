public class Location 
{
    private String Location;
    private Fare fare;
    private Timer timer;

    public String getLocation() 
    {
        return Location;
    }
    public void setLocation(String Location) 
    {
        this.Location = Location;
    }
    public void setFare(Fare fare)
    {
        this.fare=fare;
    }
    public Fare getFare()
    {
        return fare;
    }
    public void setTimer(Timer timer) 
    {
        this.timer = timer;
    }
    public Timer getTimer() 
    {
        return timer;
    }
}
