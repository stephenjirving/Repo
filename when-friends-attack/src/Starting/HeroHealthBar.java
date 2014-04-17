package Starting;

import java.awt.Color;
import acm.graphics.*;

import acm.graphics.GOval;

public class HeroHealthBar extends GCompound
{
    private double healthBar;
   
    public HeroHealthBar(double health)
    {
        healthBar = health;
        drawHeroHealthBar(health);
    }
   
    private void drawHeroHealthBar(double currentHealth)
    {
        //draw head
        GRect barRed = new GRect(0, 0, 100, 25);
        barRed.setFilled(true);
        barRed.setColor(Color.red);
        add(barRed);
       
        GRect barGreen = new GRect(0, 0, currentHealth, 25);
        barGreen.setFilled(true);
        barGreen.setColor(Color.green);
        add(barGreen);
       
        GRect barBorder = new GRect(0, 0, 100, 25);
        barBorder.setFilled(false);
        barBorder.setColor(Color.black);
        add(barBorder);
    }
}