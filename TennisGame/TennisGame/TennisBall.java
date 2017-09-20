import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TennisBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TennisBall extends Actor
{
    /**
     * Act - do whatever the TennisBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Back back;
    private Front front;
    private TwoPlayer world;
    private int speed;
    private int x;
    private int y;
    private int random;
    private boolean leftSideBack;
    private boolean leftSideFront;
    private boolean backLastHitter;
    private int backScore;
    private int frontScore;
    private Timer timePlayed;
    public void act() 
    {
        int x=getX();
        int y=getY();
        leftSideBack=back.leftSide();
        leftSideFront=front.leftSide();
        setLocation(x+random, y+speed);
     
        if(backLastHitter==false)
        {
        if(hitBallBack()&&j())
        {
            speed=7;
            speed+=1;
            speed=(speed*-1);
            random=random();
            backLastHitter=true;
        }
        if(hitBallBack()&&k())
        {
            speed=7;
            speed*=-1;
            if (leftSideBack==true)
            {
            random=Greenfoot.getRandomNumber(2)+3;
            }
        else
            {
            random=-(Greenfoot.getRandomNumber(2)+3);
            }
            backLastHitter=true;
        }
}
       
if(backLastHitter==true)
{
        if(hitBallFront()&&c())
        {
            speed=-7;
            speed-=1;
            speed=(speed*-1);
            random=random();
            backLastHitter=false;
        }
        
        if(hitBallFront()&&v())
        {
            speed=-7;
            speed*=-1;
            if(leftSideFront==true)
            {
                random=Greenfoot.getRandomNumber(2)+3;
            }
            else
            {
            random=-(Greenfoot.getRandomNumber(2)+3);
            }
            backLastHitter=false;
        }
    }
        end();
    }    
    public TennisBall(Back b, Front f)
    {
        speed=7;
        back=b;
        front=f;
        backLastHitter=false;
    }
    
    public boolean hitBallBack()
    {
        boolean x = false;
   
        if(isTouching(Back.class))
        {
            x=true;
        }
        return x;
    }
    public boolean hitBallFront()
    {
        boolean x = false;
   
        if(isTouching(Front.class))
        {
            x=true;
        }
        return x;
    }
    public boolean k()
    {
        boolean x = false;
        if (Greenfoot.isKeyDown("'"))
        {
            x=true;
        }
        return x;
    }
    public boolean j()
    {
        boolean x = false;
      if(Greenfoot.isKeyDown(";"))
       {
              x=true;      
       }
       return x;
    }
    public boolean c()
    {
        boolean x = false;
      if(Greenfoot.isKeyDown("c"))
       {
              x=true;      
       }
       return x;
    }
    public boolean v()
    {
        boolean x = false;
      if(Greenfoot.isKeyDown("v"))
       {
              x=true;      
       }
       return x;
    }
    public int random()
    {
        random=Greenfoot.getRandomNumber(3)-1;
        return random;
    }
    public void end()
    {
        int y=getY();
        if(y>698)
        {
            frontScore+=1;
            back.reset();
            front.reset();
            resetBall();
            Greenfoot.playSound("clap.mp3");
        }
        if (y<2)
        {
            backScore+=1;
            back.reset();
            front.reset();
            resetBall();
            Greenfoot.playSound("clap.mp3");
        }
    }
    public int getScoreFront()
    {
        return frontScore;
    }
    public int getScoreBack()
    {
        return backScore;
    }
    public void resetBall()
    {
        setLocation(100, 150);
        speed=4;
        backLastHitter=false;
    }
    
    
}
