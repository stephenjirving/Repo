package Starting;
/*Stephen Irving
May 8, 2013
Cow.java
It's a cow class
*/


import acm.graphics.*;

import java.awt.Color;
import acm.util.RandomGenerator;

public class Friend extends GCompound
{
    private double cowSpeedX;
    private double cowSpeedY;
    private double cowAttackDamage;
    private double cowHealth;
   
    //private double cowRating;
    private RandomGenerator cowHat;
   
    //get the cows speedX
    public double getCowSpeedX()
    {
        return cowSpeedX;
    }

    //get the cows speedY
    public double getCowSpeedY()
    {
        return cowSpeedY;
    }

   
    //set the cows speedX
    public void setCowSpeedX(double cowSpeedX)
    {
        this.cowSpeedX = cowSpeedX;
    }

    //set the cows speedY
    public void setCowSpeedY(double cowSpeedY)
    {
        this.cowSpeedY = cowSpeedY;
    }
   
    //get cow attack damage
    public double getCowAttackDamage() {
        return cowAttackDamage;
    }
   
    //public Cow()
   // {
        //this(Color.GREEN);
   // }
   
    public Friend(Double rating)
    {
        cowHat = new RandomGenerator();
       
        //depending the on the difficulty rating, the game makes a random cow for your level
        if(rating >= 75)
        {
            initCow(rating);
            cowSpeedX = cowHat.nextDouble(-3, 3);
            cowSpeedY = cowHat.nextDouble(-3, 30);
            cowAttackDamage = 3;
        }
        else if(rating < 75 && rating >= 25)
        {
            initCow(rating);
            cowSpeedX = cowHat.nextDouble(-2, 2);
            cowSpeedY = cowHat.nextDouble(-2, 2);
            cowAttackDamage = 2;
        }
        else
        {
            initCow(rating);
            cowSpeedX = cowHat.nextDouble(-1, 1);
            cowSpeedY = cowHat.nextDouble(-1, 1);
            cowAttackDamage = 1;
        }
       
    }
   
   

    private void initCow(Double cowRating)
    {
       
        if(cowRating >= 75)
        {
            GImage cowImage = new GImage("Matt.png");
            cowImage.scale(cowHat.nextDouble(1, 1.5));
            add(cowImage);
        }
        else if(cowRating < 75 && cowRating >= 50)
        {
            GImage cowImage = new GImage("Chris Vishoot.png");
            cowImage.scale(cowHat.nextDouble(.4, 1));
            add(cowImage);
        }
        else if(cowRating < 50 && cowRating >= 25)
        {
            GImage cowImage = new GImage("ChrisGores.png");
            cowImage.scale(cowHat.nextDouble(.6, .9));
            add(cowImage);
        }
        else
        {
            GImage cowImage = new GImage("Kaleb.png");
            cowImage.scale(cowHat.nextDouble(.4, .6));
            add(cowImage);
        }
       
    }
   
    //Parameterized constructor
    //public Cow(Color cowColor)
    //{
        //initCow(cowColor);
    //}
}//end class