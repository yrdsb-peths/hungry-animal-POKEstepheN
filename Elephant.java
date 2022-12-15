import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant can move and eat the apple falling from the sky.
 * 
 * Stephen Liu 
 * November 25, 2022
 */
public class Elephant extends Actor
{
    //Create an elephant sound and list to store the elephant's animation
    GreenfootSound elephantSound=new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight=new GreenfootImage[8];
    GreenfootImage[] idleLeft=new GreenfootImage[8];
    
    int imageIndex=0;
    String facing = "right";
    SimpleTimer animationTimer=new SimpleTimer();
    
    public Elephant()
    {
        //The animation list now contains the movement of the elephants
        
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
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    
    //Changes the picture of the elephant to create an animation
    public void animateElephant()
    {
        if(animationTimer.millisElapsed()<100)
        {
            return;
        }
        animationTimer.mark();
        
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
        //If the user presses w, a, s, d, the elephant would move in a direction
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
    
    //Checks if the elephant touches the apple and then performs different actions
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            //play sound
            elephantSound.play();
            
            //Remove the eaten apple
            removeTouching(Apple.class);
            
            //The score will increase and a new apple will fall
            MyWorld myworld=(MyWorld) getWorld();
            myworld.increaseScore();
            myworld.spawnApple();
        }
    }
}
