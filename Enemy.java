package Midterm.Local_version.Instage;

import java.awt.*;
import java.util.Random;

class Enemy implements Avatar {
    private int x, y, width=18, height=30;
    Random r = new Random();
    Float h = 0.5F + r.nextFloat()*0.4F;
    Float s = r.nextFloat();
    Float b = r.nextFloat();
    // random position
    public Enemy(){
        this.x = (int)(Math.random()*(400-this.width));
        this.y = -(int)(Math.random()*600);
    }
    public int getY(){
        return this.y;
    }
    public int getX(){
        return this.x;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.getHSBColor(this.h, this.s, this.b));
        g.drawRect(this.x, this.y, this.width, this.height);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    public void timePast(){
        this.y += 1;
    }
}
