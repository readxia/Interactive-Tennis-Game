import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Actor
{
    private GreenfootImage[] runningFrames;
    private GreenfootImage[] idleFrames;
    private GreenfootImage[] activeFrames;
    private GreenfootImage[] hittingFrame;
    private int currentFrame;
    private int speed;
    private boolean hitBall;
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = activeFrames[currentFrame];
        setImage(img);
        currentFrame++;
         if( currentFrame >= activeFrames.length )
        {
            currentFrame = 0;
        }
        if (net())
        {
            moveNet();
        }
        else checkKeyboard();
        if (Greenfoot.isKeyDown(";")||Greenfoot.isKeyDown("'"))
        {
            speed=3;
        }
        else speed=5;
    }    
    public Back()
    {
        setImage("back/back-0.png");
        speed=5;
        runningFrames=new GreenfootImage[5];
        for( int i = 0; i < runningFrames.length; i++ )
        {
            runningFrames[i] = new GreenfootImage("back/back-" + i + ".png");
        }
        activeFrames = runningFrames;
        hittingFrame=new GreenfootImage[1];
        hittingFrame[0]=new GreenfootImage("back/back-swing.png");
        currentFrame=0;
        idleFrames=new GreenfootImage[1];
        idleFrames[0]=new GreenfootImage("back/back-0.png");
    }
    public void checkKeyboard()
    {
        int x = getX();
        int y = getY();
        if ( Greenfoot.isKeyDown( "left" ) )
        {
            setLocation( x - speed, y);
            activeFrames=runningFrames;
        }  
        else if ( Greenfoot.isKeyDown( "right" ) )
        {
            setLocation( x + speed, y);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "up" ) )
        {
            setLocation(x, y-speed);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "down"  ) )
        {
            setLocation(x,y+speed);
            activeFrames=runningFrames;
        }
        else
        {
            activeFrames=idleFrames;
            currentFrame=0;
        }
        downTheLine();
    }   
    public boolean leftSide()
    {
        boolean poop = true;
        int x=getX();
        if(x>225)
        {
            poop=false;
        }
        return poop;
    }
    public boolean downTheLine()
    {
        boolean hit = false;
        if (Greenfoot.isKeyDown(";")||Greenfoot.isKeyDown("'"))
        {
            if (isTouching(TennisBall.class))
            {
                hit = true;
                Greenfoot.playSound("grunt.mp3");
            }
            currentFrame=0;
            activeFrames=hittingFrame;
        }
        return hit;
        
    }
    public void moveNet()
    {
        int x = getX();
        int y = getY();
        if ( Greenfoot.isKeyDown( "left" ) )
        {
            setLocation( x - speed, y);
            activeFrames=runningFrames;
        }  
        else if ( Greenfoot.isKeyDown( "right" ) )
        {
            setLocation( x + speed, y);
            activeFrames=runningFrames;
        }
        else if (Greenfoot.isKeyDown( "down"  ) )
        {
            setLocation(x,y+speed);
            activeFrames=runningFrames;
        }
        else
        {
            activeFrames=idleFrames;
            currentFrame=0;
        }
        downTheLine();
    }   
    public boolean net()
    {
        boolean z=false;
        int x=getX();
        int y=getY();
        if(y<350)
        {
           z = true;
        }
        return z;
    }
    public void reset()
    {
        setLocation(112, 650);
    }
    
}

