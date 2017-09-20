import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoPlayer extends World
{
    private Back back;
    private Front front;
    private TwoPlayer world;
    private TennisBall ball;
    private int backScore;
    private int frontScore;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TwoPlayer()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 700, 1); 
        back=new Back();
        addObject(back, 112, 650);
        front=new Front();
        addObject(front,275,50);
        ball=new TennisBall(back, front);
        addObject (ball, 100, 150);
    }
    public void act()
    {
        frontScore=ball.getScoreFront();
        backScore=ball.getScoreBack();
        showText("Score: "+backScore+"-"+frontScore, 475, 350);
        topWins();
        bottomWins();
    }
    public void topWins()
    {
        if(frontScore>=10)
        {
            Greenfoot.playSound("tenniswin.mp3");
            TopWins t=new TopWins();
            Greenfoot.setWorld(t);

        }
    }
    public void bottomWins()
    {
        if(backScore>=10)
        {
            Greenfoot.playSound("tenniswin.mp3");
            BottomWins b=new BottomWins();
            Greenfoot.setWorld(b);

        }
    }
}
