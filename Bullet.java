package Midterm.Local_version.Instage;

import java.awt.*;

public class Bullet implements Avatar {
    private int x, y, width=2, height=4;
    // position decided by the player circle
    public Bullet(int x, int y){
        this.x=x;
        this.y=y;
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
        g.setColor(Color.orange);
        g.drawRect(this.x, this.y, this.width, this.height);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    public void timePast(){
        this.y -= 5;
    }
}
