import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    public Apple()
    {
        setRotation(90);
    }
    public void act()
    {
        move(1);
        int bottomY=getWorld().getHeight();
        if(getY()>bottomY)
        {
            MyWorld world=(MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }
    }
}
