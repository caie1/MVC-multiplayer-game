package Midterm.Local_version.Instage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Player extends Controller {
    String name;
    int x, y, radius=14;
    Color c;
    Circle circle;
    ArrayList<Bullet> bullets = new ArrayList<>();
    public Player(Color c, String name, Model world, View view) {
        super(world, view);
        this.name = name;
        this.c = c;
        this.setTitle( this.name );
        this.x = (int)(Math.random() * 360)+20;
        this.y = (int)(Math.random() * 150)+410;
        this.circle = new Circle(this.c, this.name, this.x, this.y, this.radius);
        Bullet b = new Bullet(this.x,this.y-this.radius);
        bullets.add(b);
        ((Counter<Avatar>)this.world.state).update(this);
    }
    public String toString(){
        return this.name;
    }
    public void teh(State state) {
        this.view.set(state);
        this.view.repaint();
    }
    public void keh(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 37) { this.x -= 5; } // west
        else if (code == 38) { this.y -= 5; } // north
        else if (code == 39) { this.x += 5; } // east
        else if (code == 40) { this.y += 5; } // south
        else {
            Bullet b = new Bullet(this.x,this.y-this.radius);
            bullets.add(b);
        }
        this.circle = new Circle(this.c, this.name, this.x, this.y, this.radius);
        this.teh(this.world.state);
        ((Counter<Avatar>)this.world.state).update(this);
    }
}
