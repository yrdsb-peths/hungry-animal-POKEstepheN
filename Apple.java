import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    int speed=1;
    public void act()
    {
        int x=getX();
        int y=getY()+speed;
        setLocation(x, y);
        
        int bottomY=getWorld().getHeight();
        if(getY()>bottomY)
        {
            MyWorld world=(MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed=spd;
    }
}
