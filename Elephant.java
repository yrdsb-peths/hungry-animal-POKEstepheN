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
    GreenfootImage[] idleRight=new GreenfootImage[8];
    GreenfootImage[] idleLeft=new GreenfootImage[8];
    
    String facing = "right";
    
    public Elephant()
    {
        for(int i=0; i<idleRight.length; i++)
        {
            idleRight[i]=new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i=0; i<idleLeft.length; i++)
        {
            idleLeft[i]=new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        setImage(idleRight[0]);
    }
    
    int imageIndex=0;
    public void animateElephant()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex=(imageIndex+1)%idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex=(imageIndex+1)%idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+5, getY());
            facing="right";
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-5, getY());
            facing="left";
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
