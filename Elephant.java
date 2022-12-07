import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant can move.
 * 
 * Stephen Liu 
 * November 25, 2022
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound=new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle=new GreenfootImage[8];
    public Elephant()
    {
        for(int i=0; i<idle.length; i++)
        {
            idle[i]=new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idle[i].scale(100, 100);
        }
        setImage(idle[0]);
    }
    
    int imageIndex=0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex=(imageIndex+1)%idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+5, getY());
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-5, getY());
        }
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-5);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+5);
        }
        eat();
        animateElephant();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            //play sound
            elephantSound.play();
            
            removeTouching(Apple.class);
            
            MyWorld myworld=(MyWorld) getWorld();
            myworld.increaseScore();
            myworld.spawnApple();
        }
    }
}
