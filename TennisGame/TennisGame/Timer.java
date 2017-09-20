/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer  
{
    // instance variables - replace the example below with your own
    private long start;
    private long end;

    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
        long start = System.currentTimeMillis();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public long getTimePassed()
    {
        long diff = start - end;
        return 0;
    }
    public boolean hasTimePassed(long x)
    {
        if ( x > 1000 )
        {
          return true;
        }
        return false;
    }
    public void reset()
    {
        start = System.currentTimeMillis();
    }
}
