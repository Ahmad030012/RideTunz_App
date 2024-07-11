public class User
{
    private String Name;
    private long Ph_no;
    private String Address;
    private Driver driver;
    private Location location;
    private Safety safety;
    private Rating rating;
    private Music music;

    public void setMusic(Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public void SetInfo(String Name, long Ph_no)
    {
        this.Name=Name;
        this.Ph_no=Ph_no;
    }
    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    public String getAddress()
    {
        return Address;
    }
    public String getName()
    {
        return Name;
    }
    public long getPh_no()
    {
        return Ph_no;
    }
    public void setDriver(Driver driver)
    {
        this.driver=driver;
    }
    public Driver getDriver()
    {
        return driver;
    }
    public void setLocation(Location location)
    {
        this.location = location;
    }
    public Location getLocation()
    {
        return location;
    }
    public void setSafety(Safety safety)
    {
        this.safety = safety;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPh_no(long ph_no) {
        Ph_no = ph_no;
    }

    public Safety getSafety()
    {
        return safety;
    }
    public void setRating(Rating rating)
    {
        this.rating = rating;
    }
    public Rating getRating()
    {
        return rating;
    }
}