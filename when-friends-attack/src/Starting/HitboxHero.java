package Starting;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.Color;

public class HitboxHero extends GCompound
{
    private GRect bodyHitbox;
    private GOval headHitbox;

    public HitboxHero()
    {
        drawHitbox();
    }
   
    //draw hitbox
    public void drawHitbox()
    {
        bodyHitbox = new GRect(20, 25, 35, 30);
        bodyHitbox.setFilled(true);
        bodyHitbox.setColor(Color.black);
        add(bodyHitbox);
       
        headHitbox = new GOval(25, 0, 25, 25);
        headHitbox.setFilled(true);
        headHitbox.setColor(Color.black);
        add(headHitbox);
    }
}