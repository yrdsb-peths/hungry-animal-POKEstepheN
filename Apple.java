import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the object the elephant is trying to eat (touch).
 * 
 * Stephen Liu
 * November 28, 2022
 */
public class Apple extends Actor
{
    int speed=1;
    public void act()
    {
        //Makes the apple fall
        int x=getX();
        int y=getY()+speed;
        setLocation(x, y);
        
        //Makes the apple disappear and display game over if apple touches ground
        int bottomY=getWorld().getHeight();
        if(getY()>bottomY)
        {
            MyWorld world=(MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    //Sets the speed the apple falls
    public void setSpeed(int spd)
    {
        speed=spd;
    }
}
