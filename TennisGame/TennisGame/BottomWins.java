import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BottomWins extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public BottomWins()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 700, 1); 
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            TitleScreen poop=new TitleScreen();
            Greenfoot.setWorld(poop);
        }
    }
}
