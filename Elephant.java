import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant can move.
 * 
 * Stephen Liu 
 * November 25, 2022
 */
public class Elephant extends Actor
{
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
    }
}
