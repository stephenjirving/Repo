package Starting;
/*    Stephen Irving
    June 1, 2013
    DemSwords.Java
    Kill all the cows you can
 */

import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.Color;
import acm.util.RandomGenerator;
import java.awt.event.*;

public class DemSwords extends GraphicsProgram {
   
    //max number of cows
    private static final int MAX_COWS = 1000;
   
    // Declare constants to store applet height, applet width, and ball size
    private final int APP_HEIGHT = 1000;
    private final int APP_WIDTH = 1400;

    // Declare class scope variables
    private RandomGenerator hat;
   
    private Hero hero1;
    private HitboxHero hitboxHero1;
    private HeroHealthBar heroHealthBar;
    private Weapon longSwordUp;
    private Weapon longSwordDown;
    private Friend[] cows = new Friend[MAX_COWS];
   
    private GLabel scoreLabel;
    private GLabel signGameOver;
    private GLabel cowCountLabel;
    private GLabel cowDeathCountLabel;
    private GLabel healthLabel;
   
    private boolean gameOver = false;
   
    private int rate = 500;
    private int cowCount = 0;
    private int cowDeathCount = 0;
    private double points = 0;
    private double difficulty = 1.0;

    private Weapon weapon;

    private GLabel difficultyLabel;//temp

   
   
   

    public void init()
    {
       
        //set the size and add the key listeners
        setSize(APP_WIDTH, APP_HEIGHT);
        setBackground(Color.WHITE);
        addKeyListeners();
    }

    public void run() {
        // Instantiate a RandomGenerator
        hat = new RandomGenerator();

        //add hero1 hitbox
        hitboxHero1 = new HitboxHero();
        add(hitboxHero1, 200, 200);
       
        // make our first hero1
        hero1 = new Hero("bob", Color.BLUE, 100);
        add(hero1, 200, 200);
       
        heroHealthBar = new HeroHealthBar(hero1.getHeroHealth());
        add(heroHealthBar, 300, 20);
       
       
       
       
       
        //add swords
        longSwordUp = new Weapon(0);
        longSwordDown = new Weapon(1);
        add(longSwordUp, 200, 200);
        weapon = longSwordUp;

        // Instantiate a RandomGenerator
        hat = new RandomGenerator();

        // Create the score label
        scoreLabel = new GLabel("Score: ", 50, 50);
        add(scoreLabel);
       
        // Create label for number of cows
        cowCountLabel = new GLabel("Enemies: ", 50, 25);
        add(cowCountLabel);
       
        // Create label for number of dead cows
        cowDeathCountLabel = new GLabel("Enemies killed: ", 50, 75);
        add(cowDeathCountLabel);
       
        //show the difficulty(temp)
        difficultyLabel = new GLabel("Diffuclty: ", 50, 100);
        add (difficultyLabel);
       
        healthLabel = new GLabel("Health: ", 50, 125);
        add(healthLabel);

        while (gameOver == false)
        //while(hero1.getHeroHealth() > 0)
        {
           
            // Update scores
            scoreLabel.setLabel("Score: " + points);
            cowCountLabel.setLabel("Enemies: " + cowCount );
            cowDeathCountLabel.setLabel("Enemies killed: " + cowDeathCount);
            difficultyLabel.setLabel("Difficulty: " + difficulty);
            healthLabel.setLabel("Health: " + hero1.getHeroHealth());
            points++;
           
            //adds cow at the speed of the rate and then pauses for 10 ms
            if(points % rate  == 0)
            {
                addCow();
            }
            pause(10);

            for (int x = 0; x < MAX_COWS; x++)
            {
                //moves cow if it isn't null
                if(cows[x] != null)
                {
                    cows[x].move(cows[x].getCowSpeedX(), cows[x].getCowSpeedY());
   
                    // Bounce if a wall is hit (left and right walls)
                    if (cows[x].getX() + cows[x].getWidth() > APP_WIDTH || cows[x].getX() < 0)
                    {
                        cows[x].setCowSpeedX(-cows[x].getCowSpeedX());
                    }
                    // (top and bottom walls)
                    if (cows[x].getY() <= 0 || cows[x].getY() + cows[x].getHeight() >= APP_HEIGHT)
                    {
                        cows[x].setCowSpeedY(-cows[x].getCowSpeedY());
                    }
   
                    // if hero and cow collide, you lose
                    if (hitboxHero1.getBounds().intersects(cows[x].getBounds())) {
                        //gameOver = true;
                        hero1.setHeroHealth(hero1.getHeroHealth()-cows[x].getCowAttackDamage());
                        heroHealthBar = new HeroHealthBar(hero1.getHeroHealth());
                        add(heroHealthBar, 300, 20);
                       
                        if(hero1.getHeroHealth() < 0){
                            gameOver = true;
                        }
                    }
                   
                    //if the sword hits the cow, the cow dies, increase score and decrease the rate
                    if (weapon.getBounds().intersects(cows[x].getBounds()))
                    {
                        removeCow(cows[x]);
                        points = points + 10;
                        rate = (int) (rate/2 + 100/difficulty);
                        if(rate <= 0)
                        {
                            rate = 1;
                        }
                    }
                }
            }
        }// end while



        // Create game over label
        signGameOver = new GLabel("Game Over", 250, 250);
        add(signGameOver);

    }// end run

    // add new cow
    private void addCow()
    {
        //keeps cow number below MAX_COWS
        for(int i = 0; i < MAX_COWS; i++)
        {
            if(cows[i] == null)
            {
                //set cow rating being 0 and 10 times the difficulty of the game
                double cowsRating = hat.nextDouble(0, (10*difficulty ));
               
                cows[i] = new Friend(cowsRating);
                cowCount = cowCount + 1;
                difficulty = Math.sqrt(difficulty) * (((points)+3000)/3000);
               
                //adds cow at random spot
                add(cows[i], hat.nextInt(400,800), hat.nextInt(400,800));
                return;
            }
       
        }

    }//end cow

    //remove cow
    private void removeCow(Friend cowToBeRemoved)
    {
        //goes through whole array
        for(int x = 0; x < MAX_COWS; x++)
        {
            //checks to see if the cow needs to be removed
            if(cowToBeRemoved.equals(cows[x]))
            {
                remove(cowToBeRemoved);
                cows[x] = null;
                cowCount = cowCount - 1;
                cowDeathCount = cowDeathCount + 1;
                return;//go out of loop once you set your removed cow to null
            }
        }
    }
   
    // Handle keyboard events
    public void keyPressed(KeyEvent e) {
        if (!gameOver)
        {
            int key = e.getKeyCode();

            //moves your guy
            if (key == KeyEvent.VK_UP)
            {
                hero1.move(0, -15);
                weapon.move(0, -15);
                hitboxHero1.move(0, -15);
            }
            else if (key == KeyEvent.VK_DOWN)
            {
                hero1.move(0, 15);
                weapon.move(0, 15);
                hitboxHero1.move(0, 15);
            }
            else if (key == KeyEvent.VK_RIGHT)
            {
                hero1.move(15, 0);
                weapon.move(15, 0);
                hitboxHero1.move(15, 0);
            }
            else if (key == KeyEvent.VK_LEFT)
            {
                hero1.move(-15, 0);
                weapon.move(-15, 0);
                hitboxHero1.move(-15, 0);
            }
           
            //moves your sword
            else if (key == KeyEvent.VK_S)
            {
                weapon = longSwordDown;
                remove(longSwordUp);
                add(longSwordDown, hero1.getX(), hero1.getY());
            }
            else if (key == KeyEvent.VK_D)
            {
                weapon = longSwordUp;
                remove(longSwordDown);
                add(longSwordUp, hero1.getX(), hero1.getY());
            }
           
        }
    }// end keyPressed

}// end class