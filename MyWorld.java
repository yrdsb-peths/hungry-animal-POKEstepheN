import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is where the elephant moves.
 * 
 * Stephen Liu
 * November 25, 2022
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Elephant e=new Elephant();
        addObject(e, 100, 200);
    }
}
