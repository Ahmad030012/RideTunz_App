public class Timer
{
    private int min = (int)(Math.random()) + 1;
    private int sec = (int)(Math.random()*10);

    public void timerLogic() throws InterruptedException
    {
        while(min>0 || sec>0)
        {
            if(sec > 0)
            {
                sec--;
                Thread.sleep(1000);
            }
            else
            {
                min--;
                sec = 59;
                Thread.sleep(1000);
            }

        }
    }
    public void getTimeRemaining()
    {
        System.out.printf("\r\t\t\t\t\t%02d:%02d\n", min, sec);
    }
}
