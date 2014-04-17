package Starting;
/*    Stephen Irving

*/

import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;




public class Hero extends GCompound
{
    private String heroName;
    private Color heroColor;
    private double heroHealth;
    private double maxHeroHealth;
   
   

    //default constructor
    public Hero()
    {
        heroName = "Mysterious Stranger";
        heroColor = Color.PINK;
        //drawHitbox();
        drawHero();
       
    }
   
    //parameterized constructor
    public Hero(String name, Color color, double health)
    {
        heroName = name;
        heroColor = color;
        heroHealth = health;
        maxHeroHealth = health;
        //drawHitbox();
        drawHero();
       
       
    }
   
    public double getHeroHealth() {
        return heroHealth;
    }

    public void setHeroHealth(double heroHealth) {
        this.heroHealth = heroHealth;
    }

    //Method for drawing the bear
    private void drawHero()
    {
        //draw head
        GOval head = new GOval(25, 0, 25, 25);
        head.setFilled(true);
        head.setColor(heroColor);
        add(head);
       
        //draw eyes
        GRect eyes = new GRect(30, 10, 15, 5);
        eyes.setFilled(true);
        eyes.setColor(Color.RED);
        add(eyes);    
   
        //draw body
        GRect body = new GRect(20, 25, 35, 30);
        body.setFilled(true);
        body.setColor(heroColor);
        add(body);
   
        //draw arm 1
        GRect arm1 = new GRect(0, 30, 30, 5);
        arm1.setFilled(true);
        arm1.setColor(heroColor);
        add(arm1);       
       
        //draw arm 2
        GRect arm2 = new GRect(55, 30, 30, 5);
        arm2.setFilled(true);
        arm2.setColor(heroColor);
        add(arm2);
       
        //draw leg 1
        GRect leg1 = new GRect(28, 50, 5, 30);
        leg1.setFilled(true);
        leg1.setColor(heroColor);
        add(leg1);    
       
        //draw leg 2
        GRect leg2 = new GRect(44, 50, 5, 30);
        leg2.setFilled(true);
        leg2.setColor(heroColor);
        add(leg2); 
       
        //test GImage
        //GImage cat = new GImage("CatJava.jpg", 300, 300);
        //add(cat);
       
    }
   
   
   
   
}//end hero