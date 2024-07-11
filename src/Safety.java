public class Safety extends User
{
    private int Police=911;
    private long Emergency;


    @Override
    public void setPh_no(long ph_no) {
        this.Emergency=ph_no;
    }

    @Override
    public long getPh_no() {
        return Emergency;
    }

    public int getPolice()
    {
        return Police;
    }
    public String GetQuote()
    {
        String[] Quotes = 
        {
            "Safety first, buckle up!",
            "Safety doesn't happen by accident.",
            "Drive as if every child on the street were you own.",
            "Better late than never. Arrive alive.",
            "Drive like your life depends on it because it does."
        };
        int random =(int)(Math.random()*Quotes.length);
        return Quotes[random];
    }
}
