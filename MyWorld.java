import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is where the elephant moves.
 * 
 * Stephen Liu
 * November 25, 2022
 */
public class MyWorld extends World
{
    public int score=0;
    public Label scoreLabel;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Elephant e=new Elephant();
        addObject(e, 100, 200);
        
        scoreLabel=new Label(score, 80);
        addObject(scoreLabel, 50, 50);
        
        spawnApple();
    }
    public void gameOver()
    {
        Label gameOverLabel=new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    public void spawnApple()
    {
        Apple a=new Apple();
        int x=Greenfoot.getRandomNumber(getWidth());
        int y=10;
        addObject(a, x, y);
    }
}
