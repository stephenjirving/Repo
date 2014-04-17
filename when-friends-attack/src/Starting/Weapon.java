package Starting;
/*    Stephen Irving

*/

import acm.graphics.*;

import java.awt.Color;




public class Weapon extends GCompound
{
    private double swordSize=1;
   
    //default constructor
    public Weapon(int type)
    {
        if(type == 0)
        {
            drawLongSwordUp();
        }
        else
        {
            drawLongSwordDown();
        }
    }

    private void drawLongSwordUp()
    {
        //draw body
        //GRect body = new GRect(85, -80, 10, 115);
        //GRect body = new GRect(85, -80, 500, 600);
        //body.setFilled(true);
        //body.setColor(Color.BLACK);
        //add(body);
       
        GImage swordRightHand = new GImage("SwordRightHand.png", 85, 30);
        swordRightHand.scale((.2*swordSize));
        add(swordRightHand);
       
       
    }
   
    private void drawLongSwordDown()
    {
        //draw body
        //GRect body = new GRect(85, 30, 115, 10);
        //body.setFilled(true);
        //body.setColor(Color.BLACK);
        //add(body);
       
        GImage swordLeftHand = new GImage("swordLeftHand.png", -115, 30);
        swordLeftHand.scale((.2*swordSize));
        add(swordLeftHand);
    }
   
   
   
}