import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hungry Animal
 * 
 * Stephen Liu
 * November 25, 2022
 * 
 * This is where the elephant and apple moves.
 */
public class MyWorld extends World
{
    public int score=0;
    public int lives=3;
    public Label scoreLabel;
    public Label lifeLabel;
    int level=1;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //Create elephant
        Elephant e=new Elephant();
        addObject(e, 100, 200);
        
        //Create score counter
        scoreLabel=new Label(score, 80);
        addObject(scoreLabel, 50, 50);
        
        //Create life counter
        lifeLabel=new Label("Lives: "+lives, 80);
        addObject(lifeLabel, 450, 340);
        
        spawnApple();
    }
    
    //Display gameover at the end of the game
    public void gameOver()
    {
        Label gameOverLabel=new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    
    //The score counter increases each time the elephant touches the apple
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        //After five apples, the speed of the apples increase
        if(score%5==0)
        {
            level++;
        }
    }
    
    //The life counter decreases each time the apple touch the ground
    public void decreaseLife()
    {
        lives--;
        lifeLabel.setValue("Lives: "+lives);
    }
    
    //A new apple appears at the top of the window
    public void spawnApple()
    {
        Apple a=new Apple();
        a.setSpeed(level);
        int x=Greenfoot.getRandomNumber(getWidth());
        int y=10;
        addObject(a, x, y);
    }
}
